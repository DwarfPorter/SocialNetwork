package ru.geekbrains.socialnetwork;

public class SocChangeSource implements SocChangableSource {

    private int count;
    private SocSourceData dataSource;

    public SocChangeSource(SocSourceData dataSource){
        count = 0;
        this.dataSource = dataSource;
    }

    @Override
    public void add() {
        if (count < dataSource.size()){
            count ++;
        }
    }

    @Override
    public void delete() {
        if (count > 0){
            count --;
        }
    }

    @Override
    public Soc getSoc(int position) {
        return dataSource.getSoc(position);
    }

    @Override
    public int size() {
        return count;
    }
}
