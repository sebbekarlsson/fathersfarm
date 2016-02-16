package fathersfarm.test;

import fathersfarm.Component;
import fathersfarm.Instance;


class TestComponent extends Component {

    public TestComponent(Instance parent, String name) {
        super(parent, name);
    }

    @Override
    public void tick(int delta) {
        getParent().x += 1;
    }


    @Override
    public void draw(int delta) {}


    @Override
    public void added() {}

    
    @Override
    public void init(int delta) {}
}
