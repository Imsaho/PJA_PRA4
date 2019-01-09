var BigDecimal = Java.type('java.math.BigDecimal');
var RoundingMode = Java.type('java.math.RoundingMode');

function calculate(a, b, operand) {
    var result = 0;

    if (operand === "+") {
        result = a.add(b)
    }

    if (operand === "-") {
        result = a.subtract(b);
    }

    if (operand === "*") {
        result = a.multiply(b);
    }

    if (operand === "/") {
        result = a.divide(b, 7, RoundingMode.HALF_EVEN);
        if (result % 1 === 0) {
            result = a.divide(b, 0, RoundingMode.HALF_EVEN);
        }
    }

    return result.toPlainString();
}

print(calculate(a, b, operand));