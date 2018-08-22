package bean;

/**
 * Created by admain on 2018/8/20.
 */

public class HomeRecyclerBean {
    private String imgUrl;
    private String content;
    private int relayNum;//转发数
    private int likeNum;//点赞数
    private String headImage;
    private String nickName;
    private String drawingBoard;//画板名

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRelayNum() {
        return relayNum;
    }

    public void setRelayNum(int relayNum) {
        this.relayNum = relayNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDrawingBoard() {
        return drawingBoard;
    }

    public void setDrawingBoard(String drawingBoard) {
        this.drawingBoard = drawingBoard;
    }
}
