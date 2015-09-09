/**
 * Created by Zoila on 2015/9/9.
 */
object BubbleSort {
  class BubbleSort{
    def bubbleSort(array: Array[Int]):Array[Int] = {
      var i = 0
      while (i < array.length)
      {
        var j = i + 1
        while (j < array.length)
        {
          if (array(j) <= array(i))
          {
            val temp = array(j)
            array(j) = array(i)
            array(i) = temp
          }
        j += 1
        }
       i += 1
      }
      array
    }
  }
  def main (args: Array[String]){
    val test = new BubbleSort
    val array = test.bubbleSort(Array(14,3,5,20,10,9))
    var i = 0
    while (i < array.length)
    {
      print(array(i)+" ")
      i += 1
    }
  }
}
