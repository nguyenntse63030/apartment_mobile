package com.example.apartment.Presenter;


import com.example.apartment.Contract.ListNewsFragmentContract;
import com.example.apartment.Listener.List_News_Listener;
import com.example.apartment.Model.News;
import com.example.apartment.R;

import java.util.ArrayList;
import java.util.List;

public class ListNewsFragmentPresenterImpl implements ListNewsFragmentContract.listNewsFragmentPresenter {
    private List<News> listNews = new ArrayList<>();
    private ListNewsFragmentContract.listNewsFragmentView view;
    private ListNewsFragmentAdapterPresenterImpl listNewsFragmentAdapterPresenter;

    public ListNewsFragmentPresenterImpl(ListNewsFragmentContract.listNewsFragmentView view) {
        this.view = view;
    }

    @Override
    public void createAdapter() {
        listNewsFragmentAdapterPresenter = new ListNewsFragmentAdapterPresenterImpl(listNews, (List_News_Listener) view);
        view.setAdapter(listNewsFragmentAdapterPresenter);
    }

    @Override
    public void inputListNewsData() {
        listNews.add(new News("Bảo Long",
                "Có nhiều người lạ lắm, mặc dù họ chẳng hề có ý định dành cho bạn một phần nhỏ......",
                R.drawable.album11, "08/06/2019",
                "Có nhiều người lạ lắm, mặc dù họ chẳng hề có ý định dành cho bạn một phần nhỏ " +
                        "xíu nào trong cuộc đời họ nhưng lúc nào cũng muốn là một phần rất quan trọng trong cuộc đời bạn."));

        listNews.add(new News("Trung Nguyên",
                "Thời gian một người bỏ ra cho bạn là tình yêu của người đó dành cho bạn. Không phải ai rảnh.....",
                R.drawable.album10, "07/06/2019",
                "Thời gian một người bỏ ra cho bạn là tình yêu của người đó dành cho bạn. Không phải ai rảnh" +
                        " sẽ bỏ ra nhiều hơn mà là ai yêu nhiều hơn sẽ cố gắng ở bên bạn nhiều hơn."));

        listNews.add(new News("Hữu Lễ",
                "Không phải vết thương nào chảy máu cũng đều đau. Có đôi khi vết thương không nhìn thấy.....",
                R.drawable.album9, "06/06/2019",
                "Không phải vết thương nào chảy máu cũng đều đau. Có đôi khi vết thương không nhìn thấy" +
                        " máu mới thật sự là vết thương đau nhất."));

        listNews.add(new News("Hoàng Nhân",
                "Đừng lập gia đình sớm, dù bất cứ lý do nào đừng vội khi chưa sẵn sàng, chưa từng trải chưa......",
                R.drawable.album8, "05/06/2019",
                "Đừng lập gia đình sớm, dù bất cứ lý do nào đừng vội khi chưa sẵn sàng, chưa từng trải chưa" +
                        " hiểu được chung sống là một thử thách to lớn thế nào."));

        listNews.add(new News("Duy Thắng",
                "Không ai có quyền phán xét bạn vì họ không biết bạn đã trải qua những gì. Họ có thể đã nghe những.......",
                R.drawable.album7, "04/06/2019",
                "Không ai có quyền phán xét bạn vì họ không biết bạn đã trải qua những gì. Họ có thể đã nghe những " +
                        "câu chuyện nhưng họ sẽ không bao giờ có cùng cảm giác với bạn."));

        listNews.add(new News("Bình Minh",
                "Đừng mơ trong cuộc sống mà hãy sống trong giấc mơ.",
                R.drawable.album6, "03/06/2019", "aaaaa"));

        listNews.add(new News("Đức Toàn",
                "Lời nói của bạn có sức mạnh làm tan vỡ trái tim, hàn gắn mối quan hệ, khai sáng.......",
                R.drawable.album5, "02/06/2019",
                "Lời nói của bạn có sức mạnh làm tan vỡ trái tim, hàn gắn mối quan hệ, khai sáng con người và thay đổi thế giới." +
                        " Hãy nói có trách nhiệm và đừng quên trách nhiệm với lời nói của bạn."));

        listNews.add(new News("Bá Nam",
                "Còn gì đẹp bằng một trái tim đang tan vỡ vẫn có thể tiếp tục tin vào tình yêu. Còn gì cao cả bằng một con người đang trải.....",
                R.drawable.album4, "01/06/2019",
                "Còn gì đẹp bằng một trái tim đang tan vỡ vẫn có thể tiếp tục tin vào tình yêu. Còn gì cao cả bằng một con người đang trải" +
                        " qua bão tố cuộc đời mình vẫn tiếp tục có thể nâng đỡ những người khác."));
    }


}
