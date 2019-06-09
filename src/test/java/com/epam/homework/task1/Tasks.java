package com.epam.homework.task1;

import com.epam.homework.beans.JazzMusic;
import com.epam.homework.beans.Music;
import com.epam.homework.beans.PopMusic;
import com.epam.homework.beans.RockMusic;
import com.epam.homework.task5.CustomBean;
import com.epam.homework.task5.CustomScope;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Tasks {

    /**
     * CustomBeanFactory creates beans from txt file in resources directory which are found in defined package.
     * Then its registered in CustomApplicationContext.
     */
    @Test
    public void task1() {
        AbstractApplicationContext customCtx =
                new CustomApplicationContext("beans.txt", "com.epam.homework.beans");
        customCtx.refresh();

        Music pop = customCtx.getBean(PopMusic.class);
        assertThat(pop.getMusician(), equalTo("Michael Jackson"));
        assertThat(pop.getSong(), equalTo("Billie Jean"));
    }

    /**
     * CustomBeanFactoryPostProcessor creates bean which is not annotated with @Component
     */
    @Test
    public void task2() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.epam.homework.beans", "com.epam.homework.task2");

        // RockMusic.class is available from context, thanks to CustomBeanFactoryPostProcessor
        Music music = ctx.getBean(RockMusic.class);
        assertNotNull(music);
    }

    /**
     * CustomContextListener changes state of JazzMusic bean every time context changes its own state
     */
    @Test
    public void task3() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.epam.homework.beans", "com.epam.homework.task3");
        Music jazzMusic = ctx.getBean(JazzMusic.class);
        assertThat(jazzMusic.getMusician(), equalTo("Refreshed musician"));
        ctx.start();
        assertThat(jazzMusic.getMusician(), equalTo("Started musician"));
        ctx.stop();
        assertThat(jazzMusic.getMusician(), equalTo("Stopped musician"));
        ctx.close();
        assertThat(jazzMusic.getMusician(), equalTo("Closed musician"));
    }

    /**
     * CustomBeanPostProcessor sets "custom musician" for every bean before initialization
     */
    @Test
    public void task4() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.epam.homework.beans", "com.epam.homework.task4");

        Music pop = ctx.getBean(PopMusic.class);
        Music jazz = ctx.getBean(JazzMusic.class);
        assertThat(pop.getMusician(), equalTo("Custom musician"));
        assertThat(jazz.getMusician(), equalTo("Custom musician"));
    }

    /**
     * CustomScope implementation
     */
    @Test
    public void task5() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.epam.homework.task5");

        BeanDefinition customBean = ctx.getBeanDefinition("customBean");
        assertThat(customBean.getScope(), equalTo("custom"));
    }

    /**
     * Override postconstruct and predestroy bean methods from all used beans
     */
    @Test
    public void task6() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.epam.homework.beans");

        Music customCreatedPop = new PopMusic();
        Music customCreatedJazz = new JazzMusic();
        assertThat(customCreatedPop.getSong(), equalTo("Billie Jean"));
        assertThat(customCreatedJazz.getSong(), equalTo("What a wonderful world"));

        Music pop = ctx.getBean(PopMusic.class);
        Music jazz = ctx.getBean(JazzMusic.class);
        assertThat(pop.getSong(), equalTo("Inited pop song"));
        assertThat(jazz.getSong(), equalTo("Inited jazz song"));

        ctx.close();
        assertThat(pop.getSong(), equalTo("Predestroyed pop song"));
        assertThat(jazz.getSong(), equalTo("Predestroyed jazz song"));
    }
}
