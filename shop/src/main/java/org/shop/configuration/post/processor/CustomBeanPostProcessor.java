package org.shop.configuration.post.processor;

import org.shop.annotation.InjectRandomInt;
import org.springframework.asm.Type;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    private void setFieldWithInjectRandomIntAnnotation(Field field, Object bean) throws BeansException {
        field.setAccessible(true);
        try {
            field.set(bean,
                    (field.getAnnotationsByType(InjectRandomInt.class)[0].minValue()
                            + field.getAnnotationsByType(InjectRandomInt.class)[0].maxValue())
                            / 2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new BeanCreationException("Field with annotation InjectRandomInt cannot be accessed", e);
        } finally {
            field.setAccessible(false);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<Field> fields = Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectRandomInt.class)).collect(Collectors.toList());
        for (Field field : fields) {
            if (field.getType().equals(int.class)) {
                setFieldWithInjectRandomIntAnnotation(field, bean);
            } else {
                throw new TypeMismatchException(bean, int.class);
            }
        }
        return bean;
    }
}
