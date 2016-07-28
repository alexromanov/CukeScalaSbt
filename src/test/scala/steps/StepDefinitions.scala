package steps

import scala.math.BigDecimal

import calc.MyCalculator
import cucumber.api.Transform
import cucumber.api.scala.{EN, ScalaDsl}
import support.MyBigDecimalTransformer


/**
  * Created by aleksandr on 13.07.16.
  */
class StepDefinitions extends ScalaDsl with EN {

  var calculator: MyCalculator = _
  var result: Int = _
  var decResult: BigDecimal = _

  Given("""^calculator running$"""){ () =>
    calculator = new MyCalculator
  }

  When("""^I add (\d+) and (\d+)$"""){ (firstNumber:Int, secondNumber:Int) =>
    result = calculator.add(firstNumber,secondNumber)
  }

  When("""^I subtract (\d+) and (\d+)$"""){ (firstNumber:Int, secondNumber:Int) =>
    result = calculator.sub(firstNumber,secondNumber)
  }

  Then("""^result should be equal to (\d+)$"""){ (expectedResult:Int) =>
    assert(result == expectedResult, "Incorrect result")
  }

  When("""^I add ([\d\.]*) and ([\d\.]*)$"""){ (firstNum: BigDecimal @Transform(classOf[MyBigDecimalTransformer]),
                                                  secondNum: BigDecimal @Transform(classOf[MyBigDecimalTransformer]) ) =>
    decResult = calculator.add(firstNum, secondNum)
  }

  Then("""^result should be equal to ([\d\.]*)$"""){ (expected: BigDecimal @Transform(classOf[MyBigDecimalTransformer])) =>
    assert(decResult == expected)
  }
}
