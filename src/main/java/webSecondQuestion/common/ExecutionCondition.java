package webSecondQuestion.common;

import java.util.Map;

/**
 *
 */
public interface ExecutionCondition {

    /**
     *
     * @param contextMap
     * @return
     */
    Boolean check(Map<String, String> tasksOutputMap, Map<String, String> contextMap);
}
