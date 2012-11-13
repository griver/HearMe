package hearme.impl;

import hearme.IInvoker;
import hearme.ISettingsResolver;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
public class FooInvoker implements IInvoker {
    private ISettingsResolver myResolver;
    public FooInvoker(ISettingsResolver resolver) {
        if(resolver == null) throw  new NullPointerException();
        myResolver = resolver;
    }
    @Override
    public void startInBackground() {
        myResolver.resolve();
    }

    @Override
    public void stop() {

    }
}
