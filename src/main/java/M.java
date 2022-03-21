class M {
    public static void main(String[] args) {
        M m = new M();
        int r = m.FindNextPrime(0);
        System.out.println(r);
    }

    int FindNextPrime(int i) {
        int nextPrime = ++i;
        while (true) {
            if (isPrime(nextPrime)) {
                return nextPrime;
            }
            nextPrime = ++i;
        }
    }

    boolean isPrime(int n) {//判断n是否是质数
        boolean isPrimeFlag = true;//是否是质数的标志
        for (int i = n - 1; i > 1; i--) {//n除以每个比n小比1大的自然数
            if (n % i == 0) {//如果有能被整除的，则不是质数
                isPrimeFlag = false;
            }
        }
        return isPrimeFlag;
    }
}