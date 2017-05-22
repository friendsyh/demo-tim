package com.tim.web.gateway.handle;

import com.tim.common.pojo.ResultDO;
import com.tim.web.gateway.pojo.GatewayRequest;
import com.tim.web.gateway.pojo.ParamsDO;
import com.tim.web.gateway.pojo.RequestDO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 网关基础处理类
 * create by tim.syh
 */
public abstract class AbstractRequestHandler<T extends RequestDO> {
    protected static final Log logger = LogFactory.getLog(AbstractRequestHandler.class);
    
    private static final String LIMIT_KEY_DEFAULT = "limit_key_default";

//    @Autowired
//    private SentinelDiamondConfigs sentinelDiamondConfigs;

    public ResultDO invoke(T requestDO) {
        ResultDO resultDO = null;

        resultDO = this.limit(requestDO);
        if (!resultDO.isSuccess()) {
            return resultDO;
        }
        
        resultDO = this.validateParaments(requestDO);
        if (!resultDO.isSuccess()) {
            return resultDO;
        }

        resultDO = this.auth(requestDO);
        if (!resultDO.isSuccess()) {
            return resultDO;
        }
        resultDO = this.checkAcl(requestDO);
        if (!resultDO.isSuccess()) {
            return resultDO;
        }

        return invokeAction(requestDO);
    }

    public ResultDO invokeAction(T requestDO) {
        String actionMethod = getActionMethod(requestDO.getAction());
        ParamsDO paramsDO = this.map(requestDO);
        Object body = requestDO.getBody();

        //TODO gateway具体的处理
        //return super.process(paramsDO, requestDO.getBody(), apiConfigDO);
        return ResultDO.successResult(Boolean.TRUE);
    }

    protected abstract ResultDO validateParaments(T requestDO);

    protected abstract ResultDO auth(T requestDO);

    protected abstract ResultDO checkAcl(T requestDO);

    protected abstract ParamsDO map(T requestDO);

    protected abstract String render(T requestDO, ResultDO resultDO);

    private String getActionMethod(String action) {
//        Map<String, String> actionMap = DiamondUtil.get("gsp.gateway.action.method", DiamondUtil.<String, String>getMapValueBuilder());
//        if (actionMap == null) {
//            return null;
//        } else {
//            return actionMap.get(action);
//        }
        return null;
    }

    protected ResultDO<Void> limit(T requestDO) {
//        Entry entry = null;
//        String limitKey = getLimitKey(requestDO);
//        String subKey = buildLimitSubKey(requestDO);
//        try {
//            entry = SphU.entry(limitKey, subKey);
//        } catch (BlockException e) {
//            return ResultDO.failureResult(ErrorCode.TOO_MANY_REQUEST.getErrorCode(),
//                    ErrorCode.TOO_MANY_REQUEST.getErrorMsg());
//
//        } catch (Throwable t) {
//            throw t;
//        } finally {
//            if (entry != null) {
//                entry.exit(limitKey);
//            }
//        }

        return ResultDO.successResult();
    }

    private String getLimitKey(T requestDO) {
//        if (requestDO instanceof GatewayRequest) {
//            String userGroup = sentinelDiamondConfigs.getUserGroup(((GatewayRequest) requestDO).getUserId());
//            if (StringUtils.isNotBlank(userGroup))
//                return userGroup;
//        }
//
//        String actionGroup = sentinelDiamondConfigs.getActionGroup(requestDO.getAction());
//        if (StringUtils.isNotBlank(actionGroup))
//            return actionGroup;

        return LIMIT_KEY_DEFAULT;
    }
    
    private String buildLimitSubKey(T requestDO) {
        String subKey;
        String action = requestDO.getAction();
        if (requestDO instanceof GatewayRequest) {
            Long userId = ((GatewayRequest) requestDO).getUserId();
            subKey = userId + "&" + action;
        } else {
            subKey = action;
        }
        
        return subKey;
    }
}
