//Matrix Parenthisization using DP

object matrixDP {
  def main(args: Array[String]) {
    val p = Array(30,35,15,5,10,20,25)
    var minCost = Array.ofDim[Int](p.length-1,p.length-1)
    for(i<-0 until p.length-1) {
      for(j<-0 until p.length-1) {
        if(i!=j) {
          minCost(i)(j) = -1
        }
      }
    }
    minCost=calcTable(p,minCost)
    for(i<-0 until p.length-1) {
      for(j<-0 until p.length-1) {
        print(minCost(i)(j)+" ")
      }
      println()
    }
  }

  
  
  def calcTable(p: Array[Int],minCost:Array[Array[Int]] ) : Array[Array[Int]] = {
    for(i<-0 until p.length-1) {
      for(j<- 0 until p.length-1) {
          minCost=findLowest(i,j,minCost)
        }
      }
    minCost
  }

  def findLowest(i: Int ,j: Int,minCost:Array[Array[Int]]) : Array[Array[Int]] = {
    if(minCost(i)(j)<0) {
      int temp=9999999
      for(k<- i until j) {
        var temp2 = findLowest(i,k,minCost)+findLowest(k+1,j,minCost)+p(i-1)*p(k)*P(j)
        if(temp2 < temp) {
          temp = temp2
        }
      }
      minCost(i)(j)=temp
    }
    println("Memoized call. Yay.")
    minCost
  }
}
