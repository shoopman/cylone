package net.meku.cylone;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;

/**
 * Created by LiangBin
 */
public abstract class BeanCopyPojoConverter<T, S>
                                           extends AbstractPojoConverter<T, S> {
                                           
    /**
     * 复制到新建的目标实例时忽略的属性，子类可覆盖
     *
     * @param target 目标Pojo
     *
     * @return 忽略的属性名数组
     */
    protected String[] ignoreFieldsWhileCreating(T target) {
        return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    
    /**
     * 复制到已存在目标实例时忽略的属性，子类可覆盖
     *
     * @param target 目标Pojo
     *
     * @return 忽略的属性名数组
     */
    protected String[] ignoreExistingWhileUpdating(T target) {
        return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    
    /**
     * 属性复制后的操作
     * 
     * @param source 源Pojo
     * @param target 目标Pojo
     */
    protected void afterBeanCopy(S source, T target) {
    }
    
    @Override
    public T toPojo(S source) {
        if (source == null) {
            return null;
        }
        
        T target = createEmptyTarget(source);
        BeanUtils.copyProperties(source, target, ignoreFieldsWhileCreating(target));
        afterBeanCopy(source, target);
        return target;
    }
    
    @Override
    public void toPojo(S source, T target) {
        if (source == null || target == null) {
            return;
        }
        
        BeanUtils.copyProperties(source, target, ignoreExistingWhileUpdating(target));
        afterBeanCopy(source, target);
    }
    
}
