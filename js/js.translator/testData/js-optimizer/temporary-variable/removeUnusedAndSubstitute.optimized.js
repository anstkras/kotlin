var log = "";

function test(a) {
    var $tmp1;
    log += $tmp1 = 1;
    return a;
}

function box() {
    if (test(3) != 3) return "fail1";
    if (log != 1) return "fail2";
    return "OK"
}