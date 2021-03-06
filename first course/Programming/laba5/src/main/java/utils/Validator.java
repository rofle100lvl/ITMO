package utils;

import annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private final Class clazz;
    private final static ArrayList<Class> wrapperClasses = new ArrayList<>(Arrays.asList(new Class[]{
            Byte.class,
            Short.class,
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            Boolean.class,
            Character.class
    }));

    public Validator(Class clazz) {
        this.clazz = clazz;
    }

    private Number objToNumber(Object object, Class type) {
        if (type.equals(byte.class) || type.equals(Byte.class)) {
            return (Byte) object;
        } else if (type.equals(short.class) || type.equals(Short.class)) {
            return (Short) object;
        } else if (type.equals(int.class) || type.equals(Integer.class)) {
            return (Integer) object;
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            return (Long) object;
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            return (Float) object;
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return (Double) object;
        }

        return null; //TODO:исправить
    }

    public boolean validate(Object object) throws IllegalAccessException {
        if (clazz.isInstance(object)) {
            for (Field field :
                    clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if(field.getType().equals(ZonedDateTime.class)){continue;}
                List<Annotation> annotations = Arrays.asList(field.getDeclaredAnnotations());

                if (!(field.getType().isPrimitive()
                        || Parser.getWrapperClasses().contains(field.getType())
                        || field.getType().equals(String.class)
                        || field.getType().isEnum())) {
                    Validator sub_validator = new Validator(field.getType());
                    if (!sub_validator.validate(field.get(object))) {
                        return false;
                    }
                }

                try {
                    Between annotation = field.getDeclaredAnnotation(Between.class);
                    if (objToNumber(field.get(object), field.getType()).doubleValue() < annotation.from() || objToNumber(field.get(object), field.getType()).doubleValue() > annotation.to())
                        return false;
                } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

                try {
                    GreaterThan annotation = field.getDeclaredAnnotation(GreaterThan.class);
                    if (objToNumber(field.get(object), field.getType()).doubleValue() < annotation.num()) return false;
                } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

                try {
                    LongerThan annotation = field.getDeclaredAnnotation(LongerThan.class);
                    if (field.get(object).toString().length() < annotation.length()) return false;
                } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

                try {
                    ShorterThan annotation = field.getDeclaredAnnotation(ShorterThan.class);
                    if (field.get(object).toString().length() > annotation. length()) return false;
                } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

                try {
                    NotEqualString annotation = field.getDeclaredAnnotation(NotEqualString.class);
                    if (field.get(object).toString().equals(annotation.string())) return false;
                } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

                try {
                    NotNull annotation = field.getDeclaredAnnotation(NotNull.class);
                    if (field.get(object) == null) return false;
                } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

            }
        }
        return true;
    }

    public boolean validateField(String value, Field field, Object object){
        field.setAccessible(true);
        if(field.getType().equals(Float.class) || field.getType().equals(float.class)) {
            try {
                field.set(object, Float.parseFloat(value));
            } catch (IllegalAccessException | NumberFormatException e) {
                return false;
            }
        }
        else if(field.getType().equals(String.class)){
            try {
                field.set(object, value);
            } catch (IllegalAccessException e) {
                return false;
            }
        }
        else if(field.getType().equals(Integer.class) || field.getType().equals(int.class)){
            try {
                field.set(object, Integer.parseInt(value));
            } catch (IllegalAccessException | NumberFormatException e) {
                return false;
            }
        }
        else if(field.getType().equals(Long.class) || field.getType().equals(long.class)){
            try {
                field.set(object, Long.parseLong(value));
            } catch (IllegalAccessException | NumberFormatException e) {
                return false;
            }
        }
        else if(field.getType().equals(Boolean.class)){
            if( !(value.equals("true") || value.equals("false"))){
                return false;
            }
            try {
                field.set(object, Boolean.parseBoolean(value));
            } catch (IllegalAccessException | NumberFormatException e) {
                return false;
            }
        }
        else if(field.getType().isEnum()){
            try {
                field.set(object, Enum.valueOf((Class<Enum>) field.getType(), value));
            } catch (IllegalAccessException | IllegalArgumentException e) {
                return false;
            }
        }
        List<Annotation> annotations = Arrays.asList(field.getDeclaredAnnotations());

        try {
            Between annotation = field.getDeclaredAnnotation(Between.class);
            if (objToNumber(field.get(object), field.getType()).doubleValue() < annotation.from() || objToNumber(field.get(object), field.getType()).doubleValue() > annotation.to())
                return false;
        } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

        try {
            GreaterThan annotation = field.getDeclaredAnnotation(GreaterThan.class);
            if (objToNumber(field.get(object), field.getType()).doubleValue() < annotation.num()) return false;
        } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

        try {
            LongerThan annotation = field.getDeclaredAnnotation(LongerThan.class);
            if (field.get(object).toString().length() < annotation.length()) return false;
        } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

        try {
            ShorterThan annotation = field.getDeclaredAnnotation(ShorterThan.class);
            if (field.get(object).toString().length() > annotation. length()) return false;
        } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

        try {
            NotNull annotation = field.getDeclaredAnnotation(NotNull.class);
            if (field.get(object) == null) return false;
        } catch (NullPointerException | IllegalAccessException ignored) { /* У поля нет этой аннотации */ }

        return true;

    }

}