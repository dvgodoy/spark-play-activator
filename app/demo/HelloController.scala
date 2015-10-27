package demo

import org.apache.spark.sql.DataFrame
import play.api.mvc._

/**
 * @author Daniel Voigt Godoy.
 */
object HelloController extends Controller {
  lazy val rdd = SparkCommons.sc.parallelize(1 to 1000)

  def index = Action {
    Ok("hello world")
  }

  /**
   * number of elements
   * @return
   */
  def count = Action {
    Ok(rdd.count().toString)
  }

  /**
   * list them all
   * @return
   */
  def list = Action {
    Ok(rdd.collect().toList.toString)
  }

  /**
   * make a filter action on the rdd and returns the sum of the remaining numbers
   * @param n
   * @return
   */
  def sum(n:String) = Action {
    Ok(rdd.filter(_ <= n.toInt).sum().toString)
  }
}
