package com.repository;

import com.model.PartView;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
public class DetailRepo {
    final List<String> details;
    final Random random = new Random();

    public DetailRepo() {
        details = new LinkedList<>();
    }

    private List<String> create(){
        details.add(random.nextInt(10), getPartRandom());
        return details;
    }

    private List<String> getListPart(){
        details.get(random.nextInt());
        return details;
    }

    private String getPartRandom(){
        final PartView[] views = PartView.values();
        final int index = random.nextInt(views.length);
        String part = String.valueOf(views[index]);
        return part;
    }
}
