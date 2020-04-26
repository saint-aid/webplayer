package com.nevermind.webplayer.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideosRepositoryTest {

    @Autowired
    VideosRepository videosRepository;

    @After
    public void clean(){
        videosRepository.deleteAll();
    }

    @Test
    public void 비디오글저장_불러오기(){
        //given
        String title = "테스트 비디오";
        String path = "C:/video";
        videosRepository.save(Videos.builder()
                                .title(title)
                                .path(path)
                                .build()
        );

        //when
        List<Videos> videosList = videosRepository.findAll();

        //then
        Videos videos = videosList.get(0);
        assertThat(videos.getTitle()).isEqualTo(title);
        assertThat(videos.getPath()).isEqualTo(path);
    }
}
