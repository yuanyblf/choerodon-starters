package io.choerodon.asgard;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AsgardApplicationContextHelper implements ApplicationContextAware {

    private DefaultListableBeanFactory springFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (applicationContext instanceof AbstractRefreshableApplicationContext) {
            AbstractRefreshableApplicationContext springContext =
                    (AbstractRefreshableApplicationContext) applicationContext;
            this.springFactory = (DefaultListableBeanFactory) springContext.getBeanFactory();
        } else if (applicationContext instanceof GenericApplicationContext) {
            GenericApplicationContext springContext = (GenericApplicationContext) applicationContext;
            this.springFactory = springContext.getDefaultListableBeanFactory();
        }
    }

    public  DefaultListableBeanFactory getSpringFactory() {
        return springFactory;
    }

}
