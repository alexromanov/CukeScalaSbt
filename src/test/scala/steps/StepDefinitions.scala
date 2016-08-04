package steps

import scala.math.BigDecimal
import calc.MyCalculator
import cucumber.api.Transform
import cucumber.api.scala.{EN, ScalaDsl}
import support.{MyBigDecimal, MyBigDecimalTransformer}


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

  Then("""^Cucumber should parse "([^"]*)" as string parameter$"""){ (param:String) =>
    assert(param.isInstanceOf[String])
  }
  Then("""^Cucumber should parse (\d+) and (\d+) as integer parameters$"""){ (firstNum:Int, secondNum:Int) =>
    assert(firstNum.isInstanceOf[Int])
    assert(secondNum.isInstanceOf[Int])
  }
  Then("""^Cucumber should parse ([\d\.]*) with custom transformer$"""){ (decimalParameter: MyBigDecimal @Transform(classOf[MyBigDecimalTransformer])) =>
    assert(decimalParameter.value == 2.2, "Unexpected result for decimal parameter")
  }
}
