//program to compare recursive fibo vs bottom up DP
//

object compareFibo {
  def main(args: Array[String]) {
    val n=40
    print("Recursive Fibo Start for n = "+n+"\n")
    var start = System.currentTimeMillis
    println(recursiveFibo(n))
    var elapsed = System.currentTimeMillis - start
    print("Time Taken : "+ elapsed +" milliseconds.\n")

    print("DP Fibo Start for n = "+n+".\n")
    start = System.currentTimeMillis
    println(recursiveFibo(n))
    elapsed = System.currentTimeMillis - start
    print("Time Taken : "+ elapsed +" milliseconds.\n")

  }

  def recursiveFibo(n: BigInt) : BigInt = { //recursive func so return type needed
    if(n==1) {
      0
    }
    else if(n==2) {
      1
    }
    else {
      recursiveFibo(n-1)+recursiveFibo(n-2)
    }
  }

  def bottomUpDPFibo(n: Int) = {
    val fiboArray:Array[BigInt] = new Array[BigInt](n)
    fiboArray(0)=0
    fiboArray(1)=1

    if(n<=2) {
      fiboArray(n-1) //-1 because of starting from 0
    }
    else {
      for(i<- 2 until n) {
        fiboArray(i) = fiboArray(i-1)+fiboArray(i-2)
      }
      fiboArray(n-1)
    }
    
  }
}
