package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        List<Advertisement> videos = storage.list();
        Comparator<Advertisement> comparator=new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int c=0;
                if (o1.getAmountPerOneDisplaying()>o2.getAmountPerOneDisplaying()){
                    c=-1;
                }
                else if (o1.getAmountPerOneDisplaying()<o2.getAmountPerOneDisplaying()){
                    c=1;
                }
                else if (o1.getAmountPerOneDisplaying()==o2.getAmountPerOneDisplaying()){
                    if (o1.getDuration()>o2.getDuration()){
                        c=-1;
                    }
                    else if (o1.getDuration()<o2.getDuration()){
                        c=1;
                    }
                    else c=0;
                }
                return c;
            }
        };
        Collections.sort(videos, comparator);
        List<Advertisement> videosToShow = new ArrayList<>();
        getMaximumProceedsVideos(videosToShow,0);

        if (storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }
        Collections.sort(videosToShow, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int c=0;
                if (o1.getAmountPerOneDisplaying()>o2.getAmountPerOneDisplaying()){
                    c=-1;
                }
                else if (o1.getAmountPerOneDisplaying()<o2.getAmountPerOneDisplaying()){
                    c=1;
                }
                else if (o1.getAmountPerOneDisplaying()==o2.getAmountPerOneDisplaying()){
                    if (o1.getOneSecondCostInThousandsParts()>o2.getOneSecondCostInThousandsParts()){
                        c=1;
                    }
                    else if (o1.getOneSecondCostInThousandsParts()<o2.getOneSecondCostInThousandsParts()){
                        c=-1;
                    }
                    else c=0;
                }
                return c;
            }
        });
        for (Advertisement advertisement:videosToShow){
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",advertisement.getName(),advertisement.getAmountPerOneDisplaying(),advertisement.getOneSecondCostInThousandsParts()));
            advertisement.revalidate();
        }
    }

    public void getMaximumProceedsVideos(List<Advertisement> list,int index){
        if ((storage.list().size()>index)){
            int totalDuration=0;
            for (Advertisement advertisement:list){
                totalDuration+=advertisement.getDuration();
            }
//            System.out.println("Total duration "+totalDuration+" dlina rolika v spiske "+storage.list().get(index).getDuration()+" index="+index);
            if ((timeSeconds-totalDuration)>=storage.list().get(index).getDuration()){
                list.add(storage.list().get(index));
            }
            getMaximumProceedsVideos(list,++index);
        }
    }


}
