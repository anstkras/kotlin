package org.jetbrains.jet.lang.diagnostics;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author svtk
 */
public class DiagnosticWithParametersFactory<T extends PsiElement, A> extends PsiElementOnlyDiagnosticFactory1<T, A> {
    public static <T extends PsiElement, A> DiagnosticWithParametersFactory<T, A> create(Severity severity, String messageStub, DiagnosticParameter<A> diagnosticParameter) {
        return new DiagnosticWithParametersFactory<T, A>(severity, messageStub, diagnosticParameter);
    }

    private final DiagnosticParameter<A> diagnosticParameter;

    protected DiagnosticWithParametersFactory(Severity severity, String message, DiagnosticParameter<A> diagnosticParameter) {
        super(severity, message);
        this.diagnosticParameter = diagnosticParameter;
    }

    @NotNull
    @Override
    protected DiagnosticWithPsiElement<T> on(@NotNull T elementToBlame, @NotNull TextRange textRangeToMark, @NotNull A argument) {
        return super.on(elementToBlame, textRangeToMark, argument).add(diagnosticParameter, argument);
    }
}
