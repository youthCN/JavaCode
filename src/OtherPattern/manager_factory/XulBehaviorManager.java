package OtherPattern.manager_factory;

import java.util.HashMap;

/**
 * 当一个组件，需要创建的时候，必须先要注册，才能找到该组件，所以需要一种 订阅（注册）组件、提供组件 模型
 * 思考：
 * 该组件需要一些额外的环境，该环境在创建对象时必须存在，所以该环境可以放到 behavior组件的构造方法初始化（初始化XulPresenter），由外界传递进来
 * 由于该组件是一个重量级的控件，所以在注册的时候， 不能直接注册该对象，需要注册该对象的字节码对象，这样不会加载该类；
 * 或者采用抽象工厂的方式，只注册抽象工厂的对象到map集合中，抽象工厂负责创建具体的behavior组件，在需要的时候调用创建方法，延迟加载重量级的组件；
 * 抽象工厂需要一个map集合维护
 */
public class XulBehaviorManager {

    private static HashMap<String, IBehaviorFactory> _behaviorFactories = new HashMap<String, IBehaviorFactory>(256);

    public static synchronized void registerBehavior(String behaviorName, IBehaviorFactory factory) {
        _behaviorFactories.put(behaviorName, factory);
    }

    public static void shutdownBehaviorManager() {

    }

    public static void initBehaviorManager() {

    }

    public interface IBehaviorFactory {
        XulUiBehavior createBehavior(XulPresenter xulPresenter);

        Class getBehaviorClass();
    }

    public static synchronized XulUiBehavior obtainBehavior(String behaviorName, XulPresenter xulPresenter) {
        final IBehaviorFactory behaviorFactory = _behaviorFactories.get(behaviorName);
        if (behaviorFactory == null) {
            return null;
        }
        return behaviorFactory.createBehavior(xulPresenter);
    }

    public static Class obtainBehaviorClass(String behaviorName) {
        final IBehaviorFactory behaviorFactory = _behaviorFactories.get(behaviorName);
        if (behaviorFactory == null) {
            return null;
        }
        return behaviorFactory.getBehaviorClass();

    }

    //代表一个组件
    static class XulUiBehavior {

        public XulUiBehavior(XulPresenter presenter) {

        }
    }

    //XulUiBehavior组件的依赖环境
    static class XulPresenter {

    }

    static class PrettyXulUiBehavior extends XulUiBehavior {
        public static final String NAME = "PrettyXulUiBehavior";

        public PrettyXulUiBehavior(XulPresenter presenter) {
            super(presenter);
        }

        public void register() {
            XulBehaviorManager.registerBehavior(NAME, new IBehaviorFactory() {
                @Override
                public XulUiBehavior createBehavior(XulPresenter xulPresenter) {
                    return new PrettyXulUiBehavior(xulPresenter);
                }

                @Override
                public Class getBehaviorClass() {
                    return PrettyXulUiBehavior.class;
                }
            });
        }

    }
}
