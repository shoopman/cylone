package net.meku.cylone;

import io.github.benas.randombeans.api.EnhancedRandom;
import net.meku.cylone.pojo.Article;
import net.meku.cylone.pojo.ArticleView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleConverterTest {

    private SimpleConverter<ArticleView, Article> converter;

    @Before
    public void setup() {
        converter = new SimpleConverter<>();
    }

    @Test
    public void testToPojo() {
        Article model = EnhancedRandom.random(Article.class);
        ArticleView view = new ArticleView();
        converter.toPojo(model, view);

        assertEquals(model.getId(), view.getId());
        assertEquals(model.getTitle(), view.getTitle());
        assertEquals(model.getContent(), view.getContent());
        assertEquals(model.getViewCount(), view.getViewCount());
    }

}