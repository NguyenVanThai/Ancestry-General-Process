package com.digitexx.ancestry.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import com.digitexx.ancestry.bean.CustomerFeedbackDetail;

/**
 * @author lqnhu
 * 
 */
public class ReflectionHelper {

	public static final String LIST_DELIMITER = ",";

	public static final Class<?> getClass(String name)
			throws ClassNotFoundException {
		return Thread.currentThread().getContextClassLoader().loadClass(name);
	}

	@SuppressWarnings("unchecked")
	public static final <T> Class<? extends T> getClass(Class<T> clasz,
			String name) throws ClassNotFoundException {
		return (Class<? extends T>) Thread.currentThread()
				.getContextClassLoader().loadClass(name);
	}

	public static final boolean hasClass(String name) {
		try {
			return getClass(name) != null;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	public static final <T> T newInstance(Class<T> clasz)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Constructor<T> c = clasz.getDeclaredConstructor(new Class[] {});
		return c.newInstance(new Object[] {});
	}

	public static final Object newInstance(String className)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {
		Class<?> clasz = getClass(className);
		Constructor<?> c = clasz.getDeclaredConstructor(new Class[] {});
		return c.newInstance(new Object[] {});

	}

	@SuppressWarnings("unchecked")
	public static final <T> T newInstance(Class<T> clasz, Object params[],
			Class<?> paramClasses[]) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException {
		Constructor<?> c = clasz.getDeclaredConstructor(paramClasses);
		c.setAccessible(true);
		return (T) c.newInstance(params);
	}

	@SuppressWarnings("unchecked")
	public static final <T> T newInstance(Class<T> clasz, Object... params)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {
		Class<?> paramClasses[];
		if (params != null) {
			paramClasses = new Class[params.length];
			for (int index = 0; index < paramClasses.length; index++) {
				paramClasses[index] = params[index].getClass();
			}
		} else {
			paramClasses = new Class[0];
		}
		Constructor<?> c = clasz.getDeclaredConstructor(paramClasses);
		c.setAccessible(true);
		return (T) c.newInstance(params);
	}

	public static Object evaluateMethod(Object object, String name,
			Object params[]) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException {
		return evaluateMethod(object.getClass(), object, name, params);
	}

	public static final Method getMethod(Class<?> clasz, String methodName)
			throws NoSuchMethodException {
		Class<?> paramsClasses[] = new Class[0];
		return getMethod(clasz, methodName, paramsClasses);
	}

	public static final Method getMethod(Class<?> clasz, String methodName,
			Class<?> paramsClasses[]) throws NoSuchMethodException {
		try {
			Method method = clasz.getDeclaredMethod(methodName, paramsClasses);
			method.setAccessible(true);
			return method;

		} catch (NoSuchMethodException e) {
			Class<?> superClass = clasz.getSuperclass();
			if (superClass != null) {
				return getMethod(superClass, methodName, paramsClasses);
			} else {
				throw e;
			}
		}
	}

	public static final Object evaluateMethod(Class<?> clasz, Object object,
			String name, Object params[]) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {
		Class<?> paramsClasses[];
		if (params != null && params.length > 0) {
			paramsClasses = new Class[params.length];
			for (int index = 0; index < params.length; index++) {
				if (params[index] != null) {
					paramsClasses[index] = params[index].getClass();
				} else {
					paramsClasses[index] = Object.class;
				}
			}
		} else {
			paramsClasses = new Class[0];
		}
		try {
			Method method = clasz.getDeclaredMethod(name, paramsClasses);
			method.setAccessible(true);
			Object ret = method.invoke(object, params);
			return ret;

		} catch (NoSuchMethodException e) {
			Class<?> superClass = clasz.getSuperclass();
			if (superClass != null) {
				return evaluateMethod(superClass, object, name, params);
			} else {
				throw e;
			}
		}
	}

	public static final Object evaluateMethod(Class<?> clasz, Object object,
			String name, Object params[], Class<?> paramsClasses[])
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException {
		try {
			Method method = clasz.getDeclaredMethod(name, paramsClasses);
			Object ret = method.invoke(object, params);
			return ret;

		} catch (NoSuchMethodException e) {
			Class<?> superClass = clasz.getSuperclass();
			if (superClass != null) {
				return evaluateMethod(superClass, object, name, params,
						paramsClasses);
			} else {
				throw e;
			}
		}
	}

	public static final Object evaluateMethod(Class<?> clasz, Object object,
			String name) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException {
		Object[] params = new Object[0];
		Class<?>[] paramsClasses = new Class[0];
		return evaluateMethod(clasz, object, name, params, paramsClasses);
	}

	public static final boolean hasMethod(Class<?> clasz, String name,
			Class<?> paramsClasses[]) {
		try {
			return clasz.getDeclaredMethod(name, paramsClasses) != null;
		} catch (NoSuchMethodException e) {
			Class<?> superClass = clasz.getSuperclass();
			if (superClass != null) {
				return hasMethod(superClass, name, paramsClasses);
			} else {
				return false;
			}
		}
	}

	public static final boolean hasMethod(Class<?> clasz, String name) {
		Class<?>[] paramsClasses = new Class[0];
		return hasMethod(clasz, name, paramsClasses);
	}

	public static final Object getField(Class<?> clasz, Object object,
			String name) throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field field = clasz.getDeclaredField(name);
		field.setAccessible(true);
		Object fieldValue = field.get(object);
		return fieldValue;
	}

	public static final Object getFieldValue(Object beanObject, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Class<?> clasz = beanObject.getClass();
		Field field = clasz.getDeclaredField(fieldName);
		field.setAccessible(true);
		Object fieldValue = field.get(beanObject);
		return fieldValue;
	}

	public static final Object castTo(Object src, Class<?> resultClass)
			throws SecurityException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {

		if (resultClass.isInstance(src)) {
			return resultClass.cast(src);
		} else if (resultClass.getName().equals("long")) {
			return ((Long) castTo(src, Long.class)).longValue();
		} else if (resultClass.getName().equals("int")) {
			return ((Integer) castTo(src, Integer.class)).intValue();
		} else if (resultClass.getName().equals("float")) {
			return ((Float) castTo(src, Float.class)).floatValue();
		} else if (resultClass.getName().equals("double")) {
			return ((Double) castTo(src, Double.class)).doubleValue();
		} else if (resultClass.getName().equals("boolean")) {
			return ((Boolean) castTo(src, Boolean.class)).booleanValue();
		} else if (resultClass.getName().equals("short")) {
			return ((Short) castTo(src, Short.class)).shortValue();
		} else if (resultClass.getName().equals("char")) {
			return ((Character) castTo(src, Character.class)).charValue();
		} else if (resultClass.getName().equals("byte")) {
			return ((Byte) castTo(src, Byte.class)).byteValue();
		} else if (Pattern.class.equals(resultClass)) {
			return Pattern.compile(src.toString());
		} else if (Class.class.equals(resultClass)) {
			return Thread.currentThread().getContextClassLoader()
					.loadClass(src.toString());
		} else {
			Object params[] = new Object[1];
			if ("java.sql.Timestamp".equals(resultClass.getName())
					&& src == null) {
				params[0] = getCurrentTimeStamp();
			} else {
				params[0] = src;
			}
			try {
				return evaluateMethod(resultClass, null, "valueOf", params);
			} catch (NoSuchMethodException e) {
				try {
					Constructor<?> c = resultClass.getConstructor(src
							.getClass());
					return c.newInstance(src);
				} catch (NoSuchMethodException ee) {
					throw new RuntimeException("Object " + src
							+ " cannot be instatiated because "
							+ resultClass.getName()
							+ " has no constructor with string argument");
				} catch (InstantiationException ee) {
					throw new RuntimeException("Object " + src
							+ " cannot be cast to " + resultClass.getName());
				}
			}
		}
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public static final void setField(Object object, String name, Object value) {
		try {
			Class<?> clasz = getClass(object.getClass().getName());
			setField(clasz, object, name, value);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	public static final void setField(Class<?> clazz, Object object,
			String name, Object value) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchFieldException {

		Field field = getField(clazz, name);
		Class<?> fieldType = field.getType();

		String setter = "set" + name.substring(0, 1).toUpperCase()
				+ name.substring(1);
		Class<?> methodParams[] = new Class[1];
		methodParams[0] = fieldType;

		try {
			Method method = clazz.getDeclaredMethod(setter, methodParams);
			method.setAccessible(true);
			method.invoke(object, castTo(value, fieldType));

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			field.setAccessible(true);
			field.set(object, castTo(value, fieldType));
		}
	}

	@SuppressWarnings("unchecked")
	public static final void setCollectionField(Object containingObject,
			String fieldName, Object value) throws SecurityException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException,
			NoSuchFieldException {
		Class<?> containingClass = getClass(containingObject.getClass()
				.getName());
		Field field = getField(containingClass, fieldName);
		// get the collection from the containing object
		Collection<Object> resultCollection = null;
		String getter = "get" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);

		try {
			Method method = containingClass.getDeclaredMethod(getter,
					new Class[0]);
			resultCollection = (Collection<Object>) method.invoke(
					containingObject, new Object[0]);
		} catch (NoSuchMethodException e) {
			field.setAccessible(true);
			resultCollection = (Collection<Object>) field.get(containingObject);
		}

		// it must be initialized by the containing object
		if (resultCollection == null) {
			throw new RuntimeException(
					"Error in ReflectionHelper.setCollectionField: "
							+ fieldName
							+ " is null. In order to set a Collection field using"
							+ "this facility, the field must be initialized (as a concrete object) in the containing bean.");
		}

		// get the type for the generic, split the list, cast its items, and
		// add them to collection
		Type fieldType = ((ParameterizedType) field.getGenericType())
				.getActualTypeArguments()[0];
		Class<?> fieldClazz = ReflectionHelper.getClass(fieldType.toString()
				.replaceFirst(".+ ", ""));

		String[] itemList = ((String) castTo(value, java.lang.String.class))
				.split(LIST_DELIMITER);
		for (String item : itemList) {
			resultCollection.add(castTo(item, fieldClazz));
		}

	}

	private static final Field getField(Class<?> clazz, String name)
			throws SecurityException, NoSuchFieldException,
			ClassNotFoundException {

		try {
			Field field = clazz.getDeclaredField(name);
			return field;
		} catch (NoSuchFieldException e) {
			Class<?> superClass = clazz.getSuperclass();
			if (superClass != null) {
				return getField(superClass, name);
			} else {
				throw e;
			}
		}
	}

	public static final Class<?> getFieldClass(Class<?> clazz, String name)
			throws SecurityException, NoSuchFieldException,
			ClassNotFoundException {
		return getField(clazz, name).getType();
	}

	private static final void loadAllFields(Class<?> clasz,
			Collection<Field> collection) {
		for (Field f : clasz.getDeclaredFields()) {
			collection.add(f);
		}
		Class<?> superclass = clasz.getSuperclass();
		if (!Object.class.equals(superclass)) {
			loadAllFields(superclass, collection);
		}
	}

	public static final Iterable<Field> getFields(Class<?> clasz) {
		List<Field> ret = new ArrayList<Field>();
		loadAllFields(clasz, ret);
		return ret;
	}

	public static final Iterable<Field> getFields(Object object) {
		return getFields(object.getClass());
	}

	private static final <T extends Annotation> void loadAllMethods(
			Class<?> clasz, Collection<Method> collection,
			Class<T> annotationClass) {
		for (Method m : clasz.getDeclaredMethods()) {
			Annotation p = m.getAnnotation(annotationClass);
			if (p != null) {
				collection.add(m);
			}
		}
		Class<?> superclass = clasz.getSuperclass();
		if (!Object.class.equals(superclass)) {
			loadAllMethods(superclass, collection, annotationClass);
		}
	}

	public static final <T extends Annotation> Iterable<Method> getAnnotatedMethods(
			Class<?> clasz, Class<T> annotationClass) {
		List<Method> ret = new ArrayList<Method>();
		loadAllMethods(clasz, ret, annotationClass);
		return ret;
	}

	public static final <T extends Annotation> Iterable<Method> getAnnotatedMethods(
			Object object, Class<T> annotationClass) {
		return getAnnotatedMethods(object.getClass(), annotationClass);
	}

	public static List<Field> loadBeanFields(Class<?> clazz) {
		return loadBeanFields(clazz, false);
	}

	public static HashMap<String, String> getMapDatataType(Class<?> clazz) {
		HashMap<String, String> mapDatatType = new HashMap<String, String>();
		Field s[] = clazz.getDeclaredFields();

		for (int i = 0; i < s.length; i++) {
			clazz = s[i].getType();
			mapDatatType.put(s[i].getName(), clazz.getName());
		}
		return mapDatatType;
	}

	private static Method getMethodNew(Class<?> clazz, String name,
			Class<?> parameterType) {
		Method m = null;
		try {
			// An empty array is not the same as a null
			if (parameterType == null) {
				m = clazz.getMethod(name, new Class<?>[] {});
			} else {
				m = clazz.getMethod(name, parameterType);
			}
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		}
		return m;
	}

	public static List<Field> loadBeanFields(Class<?> clazz,
			boolean includeReadOnly) {

		// The parent of Object is null, so this will be called once.
		// This is where we create the list that we will populate on the way
		// up the stack

		List<Field> fieldList = null;
		if (clazz == null) {
			return new ArrayList<Field>();
		}
		// start with the parent, then add this class' fields
		fieldList = loadBeanFields(clazz.getSuperclass());
		Field[] fields = clazz.getDeclaredFields();
		String suffix;

		for (int i = 0; i < fields.length; i++) {
			Class<?> type = fields[i].getType();
			suffix = fields[i].getName();

			if (suffix.length() == 1) {
				suffix = suffix.toUpperCase();
			} else {
				suffix = suffix.substring(0, 1).toUpperCase()
						+ suffix.substring(1);
			}
			Method getter = getMethodNew(clazz, "get" + suffix, null);
			Method iser = getMethodNew(clazz, "is" + suffix, null);
			Method setter = getMethodNew(clazz, "set" + suffix, type);
			// We need both a "set" and either a "get" or "is".
			if ((getter != null || iser != null)
					&& (setter != null || includeReadOnly)) {
				fieldList.add(fields[i]);
			}
		}
		return fieldList;
	}

	/**
	 * convert class to string sql insert
	 */
	public static String clazzToSqlString(Class<?> clazz, String tableName,
			String columnIgnore) {
		StringBuilder sb = new StringBuilder();
		List<Field> listField = ReflectionHelper.loadBeanFields(clazz);
		List<String> listTmp = new ArrayList<String>();
		List<String> listFieldName = new ArrayList<String>();
		sb.append("INSERT INTO ");
		sb.append(tableName);
		sb.append(" ( ");

		String fieldname = "";
		for (Field field : listField) {
			fieldname = field.getName();
			if (!fieldname.equals(columnIgnore)) {
				listFieldName.add(fieldname);
				listTmp.add("?");
			}
		}
		fieldname = StringUtil.join(listFieldName, ",");
		String tmp = StringUtil.join(listTmp, ",");
		sb.append(fieldname);
		sb.append(" )");
		sb.append(" VALUES ( ");
		sb.append(tmp);
		sb.append(" )");
		return sb.toString();
	}

	public static Map<String, String> decodeResponseObject(Object responseType,
			String prefix) {
		Map<String, String> returnMap = new HashMap<String, String>();
		Map<String, Object> rMap = ReflectionHelper.generateMapFromResponse(
				responseType, "");
		if (rMap != null && rMap.size() > 0) {
			for (Entry<String, Object> entry : rMap.entrySet()) {
				returnMap.put(entry.getKey(), entry.toString());
			}
		}
		return returnMap;
	}

	/**
	 * set value PreparedStatement
	 */
	public HashMap<String, String> getMapDataType(Class<?> clazz) {
		HashMap<String, String> mapDataType = new HashMap<String, String>();
		Class<?> c = clazz.getClass();
		Field s[] = c.getDeclaredFields();

		for (int i = 0; i < s.length; i++) {
			c = s[i].getType();
			mapDataType.put(s[i].getName(), c.getName());
		}
		return mapDataType;
	}

	public static Map<String, Object> generateMapFromResponse(
			Object responseType, String prefix) {

		if (responseType == null) {
			return null;
		}

		Map<String, Object> responseMap = new HashMap<String, Object>();

		// To check return types
		Map<String, Object> returnMap;
		Object returnObject;

		try {
			Class klazz = responseType.getClass();
			Method[] methods = klazz.getMethods();
			Package packageName;
			String propertyName;
			AccessibleObject.setAccessible(methods, true);
			for (Method m : methods) {
				if (m.getName().startsWith("get")
						&& !m.getName().equalsIgnoreCase("getClass")) {
					packageName = m.getReturnType().getPackage();
					try {
						if (prefix != null && prefix.length() != 0) {
							propertyName = prefix
									+ "."
									+ m.getName().substring(3, 4)
											.toLowerCase(Locale.US)
									+ m.getName().substring(4);
						} else {
							propertyName = m.getName().substring(3, 4)
									.toLowerCase(Locale.US)
									+ m.getName().substring(4);
						}
						if (packageName != null) {
							if (!packageName.getName().contains("com.paypal")) {
								returnObject = m.invoke(responseType, null);
								if (returnObject != null
										&& List.class.isAssignableFrom(m
												.getReturnType())) {
									List listObj = (List) returnObject;
									int i = 0;
									for (Object o : listObj) {
										if (o.getClass().getPackage().getName()
												.contains("com.paypal")) {
											responseMap
													.putAll(generateMapFromResponse(
															o, propertyName
																	+ "(" + i
																	+ ")"));
										} else {
											responseMap.put(propertyName + "("
													+ i + ")", o);
										}
										i++;
									}

								} else if (returnObject != null) {
									if (responseType.getClass().getSimpleName()
											.equalsIgnoreCase("ErrorParameter")
											&& propertyName.endsWith("value")) {
										propertyName = propertyName.substring(
												0,
												propertyName.lastIndexOf('.'));
									}
									responseMap.put(propertyName, returnObject);
								}
							} else {
								returnObject = m.invoke(responseType, null);
								if (returnObject != null
										&& m.getReturnType().isEnum()) {
									responseMap
											.put(propertyName,
													returnObject
															.getClass()
															.getMethod(
																	"getValue",
																	null)
															.invoke(returnObject,
																	null));
								} else if (returnObject != null) {
									returnMap = generateMapFromResponse(
											returnObject, propertyName);
									if (returnMap != null
											&& returnMap.size() > 0) {
										responseMap.putAll(returnMap);
									}
								}
							}

						} else {
							responseMap.put(propertyName,
									m.invoke(klazz.newInstance(), null));
						}
					} catch (IllegalAccessException e) {
					} catch (IllegalArgumentException e) {
					} catch (InvocationTargetException e) {
					} catch (InstantiationException e) {
					}
				}
			}
		} catch (Exception e) {
			return null;
		}
		return responseMap;
	}

	public static LinkedHashMap<String, Object> beanToMap(Class<?> clazz,Object beanObject, String removeField) {

		LinkedHashMap<String, Object> mapData = new LinkedHashMap<String, Object>();
		List<Field> listField = ReflectionHelper.loadBeanFields(clazz);
		List listIgnore = new ArrayList<>();
		if(removeField.contains(",")) {
			listIgnore = Arrays.asList(removeField.split(","));
		}else {
			listIgnore.add(removeField);
		}

		for (Field field : listField) {
			try {
				String fieldName = field.getName();
				if (!listIgnore.contains(fieldName)) {
					Object value = ReflectionHelper.getFieldValue(beanObject,fieldName);
					mapData.put(fieldName, value);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return mapData;
	}

	private static Class<?> getClass(Type type) {
		if (type instanceof Class) {
			return (Class) type;
		} else if (type instanceof ParameterizedType) {
			return getClass(((ParameterizedType) type).getRawType());
		} else if (type instanceof GenericArrayType) {
			Type componentType = ((GenericArrayType) type)
					.getGenericComponentType();
			Class<?> componentClass = getClass(componentType);
			if (componentClass != null) {
				return Array.newInstance(componentClass, 0).getClass();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * This is a helper method to call a method on an Object with the given
	 * parameters. It is used for dispatching to specific DAOs that do not
	 * implement the GenericDAO interface.
	 */
	public static Object callMethod(Object object, String methodName,Object... args) throws NoSuchMethodException,IllegalArgumentException, IllegalAccessException,
			InvocationTargetException 
	{
		Class<?>[] paramTypes = new Class<?>[args.length];
		for (int i = 0; i < args.length; i++) {
			if (args[i] == null)
				throw new NullPointerException(
						"No arguments may be null when using callMethod(Object, String, Object...) because every argument is needed in order to determine the parameter types. Use callMethod(Object, String, Class<?>[], Object...) instead and specify parameter types.");

			paramTypes[i] = args[i].getClass();
		}

		return callMethod(object, methodName, paramTypes, args);
	}

	/**
	 * This is a helper method to call a method on an Object with the given
	 * parameters. It is used for dispatching to specific DAOs that do not
	 * implement the GenericDAO interface.
	 */
	public static Object callMethod(Object object, String methodName,Class<?>[] paramTypes, Object... args)
			throws NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Method method = getMethod(object.getClass(), methodName, paramTypes);
		if (method == null)
			throw new NoSuchMethodException("Method: " + methodName + " not found on Class: " + object.getClass());

		if (method.isVarArgs()) {
			// put variable arguments into array as last parameter
			Object[] allargs = new Object[method.getParameterTypes().length];
			Object[] vargs = (Object[]) Array
					.newInstance(method.getParameterTypes()[method
					.getParameterTypes().length - 1].getComponentType(),args.length - method.getParameterTypes().length + 1);

			for (int i = 0; i < method.getParameterTypes().length - 1; i++) {
				allargs[i] = args[i];
			}
			for (int i = 0; i < args.length - method.getParameterTypes().length
					+ 1; i++) {
				vargs[i] = args[method.getParameterTypes().length - 1 + i];
			}
			allargs[method.getParameterTypes().length - 1] = vargs;

			return method.invoke(object, allargs);
		} else {

			return method.invoke(object, args);
		}
	}

	/**
	 * Greater dist is worse:
	 * <ol>
	 * <li>superClass = Object loses to all
	 * <li>If klass is not an interface, superClass is interface loses to all
	 * other classes
	 * <li>Closest inheritance wins
	 * </ol>
	 */
	private static int getDist(Class<?> superClass, Class<?> klass) {
		if (klass.isArray()) {
			if (superClass.isArray()) {
				superClass = superClass.getComponentType();
				klass = klass.getComponentType();
			} else {
				// superClass must be Object. An array fitting into an Object
				// must be more general than an array fitting into an Object[]
				// array.
				return 3000;
			}
		}

		if (superClass.equals(klass))
			return 0;
		if (superClass.equals(Object.class))
			return 2000; // specifying Object is always the most general
		if (superClass.isInterface()) {
			return 1000;
		}

		int dist = 0;
		while (true) {
			dist++;
			klass = klass.getSuperclass();
			if (superClass.equals(klass))
				return dist;
		}
	}

	public static <T> List<Class<?>> getTypeArguments(Class<T> baseClass,Class<? extends T> childClass) {
		Map<Type, Type> resolvedTypes = new HashMap<Type, Type>();
		Type type = childClass;
		// start walking up the inheritance hierarchy until we hit baseClass
		while (!getClass(type).equals(baseClass)) {
			if (type instanceof Class) {
				// there is no useful information for us in raw types, so just
				// keep going.
				type = ((Class) type).getGenericSuperclass();
			} else {
				ParameterizedType parameterizedType = (ParameterizedType) type;
				Class<?> rawType = (Class) parameterizedType.getRawType();

				Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
				TypeVariable<?>[] typeParameters = rawType.getTypeParameters();
				for (int i = 0; i < actualTypeArguments.length; i++) {
					resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);
				}
				if (!rawType.equals(baseClass)) {
					type = rawType.getGenericSuperclass();
				}
			}
		}

		// finally, for each actual type argument provided to baseClass,
		// determine (if possible)
		// the raw class for that type argument.
		Type[] actualTypeArguments;
		if (type instanceof Class) {
			actualTypeArguments = ((Class) type).getTypeParameters();
		} else {
			actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
		}
		List<Class<?>> typeArgumentsAsClasses = new ArrayList<Class<?>>();
		// resolve types by chasing down type variables.
		for (Type baseType : actualTypeArguments) {
			while (resolvedTypes.containsKey(baseType)) {
				baseType = resolvedTypes.get(baseType);
			}
			typeArgumentsAsClasses.add(getClass(baseType));
		}
		return typeArgumentsAsClasses;
	}
	
	/**
	 * get array field name
	 */
	public static String [] getArrayFieldName(Class<?> clazz) {

		String [] arr = null;
		List<Field> listField = loadBeanFields(clazz);
		arr = new String [ listField.size() ];
		int index = 0;
		for (Field field : listField) {
			arr[index] = field.getName();
			++index;
		}
		return arr;
	}
	
	/**
	 * get list field name
	 */
	public static List<String> getListFieldName(Class<?> clazz) {
		List<String> listFieldName = new ArrayList<String>();
		List<Field> listField = loadBeanFields(clazz);
		for (Field field : listField) {
			listFieldName.add(field.getName());
		}
		return listFieldName;
	}
	
	
	/**
	 * convert bean to Object []
	 */
	public static Object [] beanToArrayObject(Class<?> clazz , Object beanObject) {

		Object [] arr = null;
		List<Field> listField = loadBeanFields(clazz);
		arr = new Object [ listField.size() ];
		int index = 0;
		Object value = "";
        try 
        {
    		for (Field field : listField) 
    		{
				value = getFieldValue(beanObject, field.getName());
				arr[index] = value;
				++index;
    		}
				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		return arr;
	}
	

	// ====================================================================================================================

	public static void main(String[] args) {

		String tmp = clazzToSqlString(CustomerFeedbackDetail.class,
				"customer_feedback_detail", "id");
		System.out.println(tmp);
	}

}
