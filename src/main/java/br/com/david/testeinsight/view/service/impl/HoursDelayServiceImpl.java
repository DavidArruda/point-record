package br.com.david.testeinsight.view.service.impl;

import br.com.david.testeinsight.view.service.HoursDelayService;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.swing.JTable;

/**
 *
 * @author David Arruda
 */
public class HoursDelayServiceImpl implements HoursDelayService {

    @Override
    public void delayHours(JTable workingHours, JTable markingMade, JTable hoursDelay) throws Exception {

        Class tableModel = workingHours.getModel().getClass();
        Method method = tableModel.getMethod("getList");
        method.invoke(workingHours.getModel());
        

    }

}
