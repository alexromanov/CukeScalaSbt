package support

/**
  * Created by aleksandr on 14.07.16.
  */

import cucumber.api.{Transformer}
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter

class MyBigDecimalTransformer extends Transformer[MyBigDecimal] {
  override def transform(value: String): MyBigDecimal = {
    MyBigDecimal(BigDecimal(value))
  }
}
@XStreamConverter(classOf[MyBigDecimalTransformer])
case class MyBigDecimal(value: BigDecimal) {
}

