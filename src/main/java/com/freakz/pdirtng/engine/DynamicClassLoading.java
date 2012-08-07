package com.freakz.pdirtng.engine;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 4.8.2011
 * Time: 15:06
 */
public class DynamicClassLoading {

  public static List<String> scanClasses(String scanDir, String packagePath, String matchPattern) throws Exception {

    String path = scanDir + packagePath;

    File f = new File(path);
    if (!f.exists()) {
      return null;
    }
    String classPath = packagePath.replaceAll("/", ".");

    String[] files = f.list();
    List<String> classList = new ArrayList<String>();

//    _foundClasses = new String[files.length];
    for (String file : files) {
      String className = classPath + file.replaceAll(".class", "");
      if (!className.matches(matchPattern)) {

        continue;
      }
//      System.out.format("%4d -> %s --> %s\n", found, file, className);
//      instantiate(className);
      classList.add(className);
    }

    return classList;
  }

  public static Object instantiate(ClassLoader loader, String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

    if (className == null) {
      return null;
    }
    Class cl = loader.loadClass(className);
    Class[] paramTypes = {};
    Constructor ctr = cl.getConstructor(paramTypes);
    return ctr.newInstance();
  }


}
