package abc.jvm.study;

import sun.misc.URLClassPath;

import java.net.URL;

public class ClassLoaderStudy {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderStudy.class.getClassLoader() ;
        //application classloader
        System.out.println(classLoader.toString());
        //extension/platform classloader
        System.out.println(classLoader.getParent().toString());
        //bootstrap classloader 此處為c++实现 ，jvm获取不到
        try{
            System.out.println(classLoader.getParent().getParent().toString());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        URLClassPath urlClassPaths = sun.misc.Launcher.getBootstrapClassPath() ;
        URL[] urls = urlClassPaths.getURLs() ;
        for( URL url : urls){
            System.out.println(url);
        }

    }
}
