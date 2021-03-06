package com.example.barkotlin.lineView;

/**
 * <pre>
 *     author : lijunjie
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/09/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class LinkDataBean {

    /**
     * content : chair
     * q_num : 0
     * type : 0
     * col : 0
     * row : 0
     */

    private String content;
    private int q_num;
    /**
     * 0：text文本
     * 1：图片
     */
    private String type;
    private int col;
    private int row;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQ_num() {
        return q_num;
    }

    public void setQ_num(int q_num) {
        this.q_num = q_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "LinkDataBean{"
                + "content='" + content + '\''
                + ", q_num=" + q_num
                + ", type='" + type + '\''
                + ", col=" + col
                + ", row=" + row
                + '}';
    }
}
