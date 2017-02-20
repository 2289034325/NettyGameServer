package com.wolf.shoot.service.net.message;

import com.wolf.shoot.common.exception.CodecException;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by jiangwenping on 17/2/3.
 * 需要重新读取body
 */
public abstract  class AbstractNetProtoBufMessage extends AbstractNetMessage {

    public AbstractNetProtoBufMessage(){
        setNetMessageHead(new NetMessageHead());
        setNetMessageBody(new NetMessageBody());
    }

    /*解析protobuf协议*/
    public abstract void decoderNetProtoBufMessageBody() throws CodecException, Exception;

    /*释放message的body*/
    public  void releaseMessageBody() throws CodecException, Exception{
        getNetMessageBody().setBytes(null);
    }

    public abstract void release() throws CodecException;

    public abstract  void encodeNetProtoBufMessageBody() throws CodecException, Exception;

    public void setCmd(int cmd){
        getNetMessageHead().setCmd((short)cmd);
    }
    public void setSerial(int serial){
        getNetMessageHead().setSerial(serial);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + ": commandId=" + getNetMessageHead().getCmd();
    }

    public String toAllInfoString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE).replaceAll("\n", "");
    }

}
