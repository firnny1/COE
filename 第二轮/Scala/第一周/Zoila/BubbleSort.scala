/**
 * Created by Zoila on 2015/9/9.
 */
object BubbleSort {
    def bubbleSort(array: Array[Int]):Array[Int] = {
      for ( i <- 0 to array.length-1)
      {
        for (j <- i+1 to array.length-1)
        {
          if (array(j) <= array(i))
          {
            val temp = array(j)
            array(j) = array(i)
            array(i) = temp
          }
        }
      }
      array
    }

  def main (args: Array[String]){
    val array = bubbleSort(Array(14,3,5,20,10,9))
    array.foreach(println)
  }
}
