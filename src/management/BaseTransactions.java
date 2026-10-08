package management;


abstract class BaseTrasnactions {


    //Withdraw money from an account then updates the file
    public abstract int withdraw(String serialNumber, String withdrawalAmount, String methodType);

}
