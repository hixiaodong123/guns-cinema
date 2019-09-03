package com.stylefeng.guns.api.film.vo.film;

import java.util.List;

/**
 * @description: info4
 * @author: Lime
 * @create: 2019-09-02 17:51
 **/

public class FilmActorAndDirectorDescVO
{
    //演员
    private List<ActorVO> actors;

    //导演
    private ActorVO director;

    public List<ActorVO> getActors()
    {
        return actors;
    }

    public void setActors(List<ActorVO> actors)
    {
        this.actors = actors;
    }

    public ActorVO getDirector()
    {
        return director;
    }

    public void setDirector(ActorVO director)
    {
        this.director = director;
    }
}
