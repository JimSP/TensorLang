package lang;

import java.util.List;

public interface TensorFunction {
    Object apply(List<Object> args, TensorLangInterpreter interpreter);
}
