package com.xzm.video.service.Impl;

import com.xzm.video.bean.Barrage;
import com.xzm.video.bean.User;
import com.xzm.video.bean.Video;
import com.xzm.video.constant.Status;
import com.xzm.video.dao.BarrageMapper;
import com.xzm.video.dao.VideoMapper;
import com.xzm.video.service.BarrageService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BarrageServiceImpl implements BarrageService {

    @Autowired
    private BarrageMapper barrageMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Barrage barrage = barrageMapper.selectByPrimaryKey(id);
        Video video = videoMapper.selectByPrimaryKey(barrage.getVideoId());
        video.setBarrnum(video.getBarrnum()-1);
        videoMapper.updateByPrimaryKey(video);
        int index = barrageMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Map<String,String> record) {
        ResultInfo resultInfo = new ResultInfo(true);
        Barrage barrage = new Barrage();
        //{id=1, author=DIYgod, time=5.534275, text=123, color=15024726, type=0}
        Integer videoId = Integer.valueOf(record.get("id"));
        barrage.setVideoId(videoId);
        User user = new User();
        user.setId(Integer.valueOf(record.get("author")));
        barrage.setAuthor(user);
        barrage.setTime(record.get("time"));
        barrage.setText(record.get("text"));
        barrage.setStatus(Status.UNPASS.getCode());
        barrage.setColor(Integer.valueOf(record.get("color")));
        barrage.setType(Integer.valueOf(record.get("type")));
        barrage.setCreatetime(new Date());
        int index = barrageMapper.insertSelective(barrage);

        //更新系统的弹幕数目
        Video video = videoMapper.selectByPrimaryKey(videoId);
        video.setBarrnum(video.getBarrnum()+1);
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public List<List<Object>> selectByVideoId_api(Integer video_id){
        /* 注意弹幕的字段不能改变，顺序分别为时间，种类，颜色，作者，内容，否则不能显示
        {   "code":0,
            "data":[
                ["1.777",0,15024726,1,"hello world，弹幕1"],
                ["2.851507",0,16777215,1,"我发的第一个弹幕"]
              ]
         }
         */
        List<Barrage> barrages = barrageMapper.selectByVideoId(video_id);
        List<List<Object>> data = new ArrayList<>();
        for(Barrage temp:barrages){
            List<Object> demo = new ArrayList<>();
            demo.add(temp.getTime());
            demo.add(temp.getType());
            demo.add(temp.getColor());
            demo.add(temp.getAuthor());
            demo.add(temp.getText());
            data.add(demo);
        }
        return data;
    }

    @Override
    public List<Barrage> selectByVideoId(Integer video_id){
        return barrageMapper.selectByVideoId(video_id);
    }

    @Override
    public List<Barrage> selectAllAdmin() {
        return barrageMapper.selectAllAdmin();
    }

    @Override
    public ResultInfo updateByPrimaryKey(Barrage record){
        ResultInfo resultInfo = new ResultInfo(true);
        int i = barrageMapper.updateByPrimaryKeySelective(record);
        if(i==1){
            resultInfo.setCode(200);
        }else{
            resultInfo.setCode(500);
            resultInfo.setMessage("操作失败.");
        }
        return resultInfo;
    }

    @Override
    public List<Map<String, String>> countByStatus() {
        return barrageMapper.countByStatus();
    }

    @Override
    public Integer countSumByVideoUserId(Integer videoUserId) {
        return barrageMapper.countSumByVideoUserId(videoUserId);
    }
}
