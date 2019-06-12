package com.example.yt.myapplication.entitys;

import java.util.List;

public class MusicSong_bean {
    /**
     * result : true
     * errow : Success
     * listbean : [{"sonname":"说爱你（吉他男声版）（Cover：沈以诚）","sonid":"1331983202","musicurl":"http://music.163.com/song/media/outer/url?id=1331983202"},{"sonname":"说真的","sonid":"517228710","musicurl":"http://music.163.com/song/media/outer/url?id=517228710"},{"sonname":"说爱你","sonid":"210042","musicurl":"http://music.163.com/song/media/outer/url?id=210042"},{"sonname":"说唱艺术","sonid":"28828011","musicurl":"http://music.163.com/song/media/outer/url?id=28828011"},{"sonname":"说谎（抖音版）（Cover：林宥嘉）","sonid":"1332647902","musicurl":"http://music.163.com/song/media/outer/url?id=1332647902"},{"sonname":"说实话","sonid":"408212938","musicurl":"http://music.163.com/song/media/outer/url?id=408212938"},{"sonname":"说好的幸福呢 (Live)","sonid":"406907316","musicurl":"http://music.163.com/song/media/outer/url?id=406907316"},{"sonname":"说说笑笑","sonid":"300854","musicurl":"http://music.163.com/song/media/outer/url?id=300854"},{"sonname":"说余梦","sonid":"504685854","musicurl":"http://music.163.com/song/media/outer/url?id=504685854"},{"sonname":"说好了","sonid":"482809089","musicurl":"http://music.163.com/song/media/outer/url?id=482809089"},{"sonname":"说再见不应该在秋天","sonid":"272544","musicurl":"http://music.163.com/song/media/outer/url?id=272544"},{"sonname":"说爱你（二人转唱歌法）（Cover 蔡依林）","sonid":"1326818200","musicurl":"http://music.163.com/song/media/outer/url?id=1326818200"},{"sonname":"说散就散（cover：袁娅维）","sonid":"862098714","musicurl":"http://music.163.com/song/media/outer/url?id=862098714"},{"sonname":"说好的幸福呢","sonid":"409941496","musicurl":"http://music.163.com/song/media/outer/url?id=409941496"},{"sonname":"说故事的男孩儿","sonid":"573683265","musicurl":"http://music.163.com/song/media/outer/url?id=573683265"},{"sonname":"说侠","sonid":"35528030","musicurl":"http://music.163.com/song/media/outer/url?id=35528030"},{"sonname":"说过","sonid":"487587282","musicurl":"http://music.163.com/song/media/outer/url?id=487587282"},{"sonname":"说爱你（Cover 沈以诚）","sonid":"513321309","musicurl":"http://music.163.com/song/media/outer/url?id=513321309"},{"sonname":"说不清","sonid":"340667","musicurl":"http://music.163.com/song/media/outer/url?id=340667"},{"sonname":"说谎(Live)","sonid":"186174","musicurl":"http://music.163.com/song/media/outer/url?id=186174"}]
     * returnbean : null
     */

    private boolean result;
    private String errow;
    private Object returnbean;
    private List<ListbeanBean> listbean;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getErrow() {
        return errow;
    }

    public void setErrow(String errow) {
        this.errow = errow;
    }

    public Object getReturnbean() {
        return returnbean;
    }

    public void setReturnbean(Object returnbean) {
        this.returnbean = returnbean;
    }

    public List<ListbeanBean> getListbean() {
        return listbean;
    }

    public void setListbean(List<ListbeanBean> listbean) {
        this.listbean = listbean;
    }

    public static class ListbeanBean {
        /**
         * sonname : 说爱你（吉他男声版）（Cover：沈以诚）
         * sonid : 1331983202
         * musicurl : http://music.163.com/song/media/outer/url?id=1331983202
         */

        private String sonname;
        private String sonid;
        private String musicurl;

        public String getSonname() {
            return sonname;
        }

        public void setSonname(String sonname) {
            this.sonname = sonname;
        }

        public String getSonid() {
            return sonid;
        }

        public void setSonid(String sonid) {
            this.sonid = sonid;
        }

        public String getMusicurl() {
            return musicurl;
        }

        public void setMusicurl(String musicurl) {
            this.musicurl = musicurl;
        }
    }
}
