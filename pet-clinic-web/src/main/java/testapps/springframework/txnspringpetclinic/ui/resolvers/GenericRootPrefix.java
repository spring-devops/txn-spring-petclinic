package testapps.springframework.txnspringpetclinic.ui.resolvers;

public interface GenericRootPrefix <T> {
    //This is app specific and is not dependent. If dependent we will add additional interface
    public T getRootUrlPrefix();
}
