package com.jailmango.spring.application.accessor.impl.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {
        AbstractFrequenceAccessor.class
})
public class AbstractFrequenceAccessorTest {

    private AbstractFrequenceAccessor accessor;

    @Test
    public void access() {
    }

    @Test
    public void doCommonBiz() {
    }

    @Test
    public void doCustomBiz() {
    }

    @Test
    public void utils() {
    }

    @Test
    public void testMethod() throws Exception {
        // PowerMockito.verifyPrivate(AbstractFrequenceAccessor.class).invoke("calculate", 2);

        accessor = Mockito.mock(AbstractFrequenceAccessor.class, Mockito.CALLS_REAL_METHODS);

        PowerMockito.verifyPrivate(accessor).invoke("calculate", 2);

        System.out.println("end...");
    }
}