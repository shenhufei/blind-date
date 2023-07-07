package com.wangzaiplus.test.util;

import com.wangzaiplus.test.annotation.ColNum;
import com.wangzaiplus.test.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class BeanUtils {

    private static final String TYPE_STRING = "String";
    private static final String TYPE_DATE = "Date";
    private static final String TYPE_INT = "int";
    private static final String TYPE_INTEGER = "Integer";
    private static final String TYPE_LONG = "Long";
    private static final String TYPE_DOUBLE = "Double";
    private static final String TYPE_BOOLEAN = "Boolean";
    private static final String TYPE_BIG_DECIMAL = "BigDecimal";

    public static void convert(List<String> list, Object o) throws Exception {

    }

}
