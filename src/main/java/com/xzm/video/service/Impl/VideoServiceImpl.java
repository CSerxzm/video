package com.xzm.video.service.Impl;

import com.xzm.video.annotation.MyIncreBy;
import com.xzm.video.annotation.MyLock;
import com.xzm.video.bean.*;
import com.xzm.video.constant.LockName;
import com.xzm.video.constant.LockType;
import com.xzm.video.constant.ResultCode;
import com.xzm.video.dao.*;
import com.xzm.video.service.TagService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BarrageMapper barrageMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private CoinHistoryMapper coinHistoryMapper;

    @Autowired
    private LikeHistoryMapper likeHistoryMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = videoMapper.deleteByPrimaryKey(id);
        //删除视频对应的评论和弹幕，以及标签
        commentMapper.deleteByVideoId(id);
        barrageMapper.deleteByVideoId(id);
        tagMapper.deleteByVideoId(id);
        //删除投币、点赞、收藏、历史记录
        favoriteMapper.deleteByVideoId(id);
        coinHistoryMapper.deleteByVideoId(id);
        likeHistoryMapper.deleteByVideoId(id);
        historyMapper.deleteByVideoId(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Video record,String tags) {
        ResultInfo resultInfo = new ResultInfo(true);
        String tagStr = tags.replaceAll("，",",");
        String[] tagStrs = tagStr.split(",");
        int index = videoMapper.insertSelective(record);
        for(String temp : tagStrs){
            tagMapper.insertSelective(new Tag(temp,index));
        }
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    @MyIncreBy
    public Video selectByPrimaryKey(Integer id) {
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setViewnum(video.getViewnum()+1);
        videoMapper.updateByPrimaryKey(video);
        return video;
    }

    @Override
    public Video selectByPrimaryKeyAdmin(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        return video;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(Video record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = videoMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public List<Video> selectAll(){
        return videoMapper.selectAll();
    }

    @Override
    public List<Video> selectAllAdmin() {
        return videoMapper.selectAllAdmin();
    }

    @Override
    public Map<String,List<Video>> selectNewByType(Integer size){
        Map<String,List<Video>> map = new HashMap();
        List<Type> types = typeMapper.selectAll();
        for(Type type:types){
            List<Video> videos = videoMapper.selectNewByTypeId(type.getId(), size);
            map.put(type.getName(),videos);
        }
        return map;
    }

    @Override
    public Map<String, List<Video>> selectHotByType(Integer size) {
        Map<String,List<Video>> map = new HashMap();
        List<Type> types = typeMapper.selectAll();
        for(Type type:types){
            List<Video> videos = videoMapper.selectHotByTypeId(type.getId(), size);
            map.put(type.getName(),videos);
        }
        return map;
    }

    @Override
    public List<Video> selectHot(Integer size){
        return videoMapper.selectHot(size);
    }

    @Override
    public List<Video> selectByTypeId(Integer type_id) {
        return videoMapper.selectByType(type_id);
    }

    @Override
    public List<Video> selectHotByTypeId(Integer type_id,Integer size) {
        return videoMapper.selectHotByTypeId(type_id,size);
    }

    @Override
    @MyLock(name= LockName.FAVORITE,type= LockType.WRITE) //该部分有待测试
    public ResultInfo addFavoriteNum(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        //检查是否已经收藏
        Favorite favorite = favoriteMapper.selectByUserIdAndVideoId(user.getId(), id);
        Video video = videoMapper.selectByPrimaryKey(id);
        if(favorite!=null){
            favoriteMapper.deleteByPrimaryKey(favorite.getId());
            video.setStarnum(video.getStarnum()-1);
            resultInfo.setCode(ResultCode.CANCEL.getCode());
        }else{
            favorite = new Favorite();
            favorite.setUserId(user.getId());
            Video videoTemp = new Video();
            videoTemp.setId(id);
            favorite.setVideo(videoTemp);
            favorite.setCreateTime(new Date());
            favoriteMapper.insert(favorite);
            video.setStarnum(video.getStarnum()+1);
            resultInfo.setCode(ResultCode.DO.getCode());
        }
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("star",video.getStarnum());
        return resultInfo;
    }

    @Override
    public ResultInfo addCoinNum(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        //投币用户
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        //检查是否已经投币
        CoinHistory coinHistory = coinHistoryMapper.selectByUserIdAndVideoId(user.getId(), id);
        Video video = videoMapper.selectByPrimaryKey(id);
        if(coinHistory!=null){
            coinHistoryMapper.deleteByPrimaryKey(coinHistory.getId());
            video.setCoinnum(video.getCoinnum()-1);
            user1.setCoinnum(user1.getCoinnum()+1);
            resultInfo.setCode(ResultCode.CANCEL.getCode());
        }else{
            if(user1.getCoinnum()<=0){
                resultInfo.setCode(ResultCode.NOTENOUGH.getCode());
                resultInfo.setMessage(ResultCode.NOTENOUGH.getName());
                return resultInfo;
            }
            user1.setCoinnum(user1.getCoinnum()-1);
            coinHistory = new CoinHistory();
            coinHistory.setUserId(user.getId());
            coinHistory.setVideoId(id);
            coinHistoryMapper.insert(coinHistory);
            video.setCoinnum(video.getCoinnum()+1);
            resultInfo.setCode(ResultCode.DO.getCode());
        }
        userMapper.updateByPrimaryKey(user1);
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("coin",video.getCoinnum());
        return resultInfo;
    }

    @Override
    public ResultInfo addLikeNum(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        //检查是否已经点赞
        LikeHistory likeHistory = likeHistoryMapper.selectByUserIdAndVideoId(user.getId(), id);
        Video video = videoMapper.selectByPrimaryKey(id);
        if(likeHistory!=null){
            likeHistoryMapper.deleteByPrimaryKey(likeHistory.getId());
            video.setLikenum(video.getLikenum()-1);
            resultInfo.setCode(ResultCode.CANCEL.getCode());
        }else{
            likeHistory = new LikeHistory();
            likeHistory.setUserId(user.getId());
            likeHistory.setVideoId(id);
            likeHistoryMapper.insert(likeHistory);
            video.setLikenum(video.getLikenum()+1);
            resultInfo.setCode(ResultCode.DO.getCode());
        }
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("like",video.getLikenum());
        return resultInfo;
    }

    @Override
    public List<Video> selectByTitleLike(String query) {
        return videoMapper.selectByTitleLike(query);
    }

    @Override
    public List<Map<String, String>> countByStatus() {
        return videoMapper.countByStatus();
    }

    @Override
    public List<Video> selectByUserId(Integer userId) {
        return videoMapper.selectByUserId(userId);
    }

    @Override
    public Integer getSumByUserId(Integer userId) {
        return videoMapper.getSumByUserId(userId);
    }
}
