package testapps.springframework.txnspringpetclinic.ui.resolvers;

public interface GenericUrlGenerator <T, K> {
    public T getViewName();
    public T getUrl(K info);
}
