package dummydata;

import com.example.homeservice.R;
import com.example.homeservice.model.NotificationModel;
import com.example.homeservice.model.OfferModel;
import com.example.homeservice.model.ProblemModel;
import com.example.homeservice.service.NotificationService;
import com.example.homeservice.service.OfferService;
import com.example.homeservice.service.ProblemService;

public class DummyData {
    public static void populateNotification() {
        NotificationService.addNotification(new NotificationModel("App Name", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("Title One", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("Notification One", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("App Name", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("Title One", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("Notification One", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("App Name", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("Title One", "This is the description for first notification i have", "21 Jan, 2021"));
        NotificationService.addNotification(new NotificationModel("Notification One", "This is the description for first notification i have", "21 Jan, 2021"));
    }

    public static void populateOffer() {
        OfferService.addOffer(new OfferModel("Rajesh Hamal", "https://i.ytimg.com/vi/hhzrul_MU6c/maxresdefault.jpg", "9845632541", "https://wallpaperaccess.com/full/91225.jpg", "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        OfferService.addOffer(new OfferModel("Rajesh Hamal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpymOtFg3-Hl7XVfqpahVQykw6dAq4VumQ-_zKbqGyDl9cYURqi4rjW05Z76OiS85ewYs&usqp=CAU", "9845632541", "https://reviews.com.np/uploads/images/Article/Hyundai/17-9-20/Ford-festive-offer-2020-body.jpg", "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        OfferService.addOffer(new OfferModel("Rajesh Hamal", "https://thehimalayantimes.com/uploads/imported_images/wp-content/uploads/2017/05/Rajesh-Hamal.jpg", "9845632541", "https://www.crushpixel.com/big-static13/preview4/special-offer-sale-fire-burn-1250537.jpg", "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        OfferService.addOffer(new OfferModel("Rajesh Hamal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpymOtFg3-Hl7XVfqpahVQykw6dAq4VumQ-_zKbqGyDl9cYURqi4rjW05Z76OiS85ewYs&usqp=CAU", "9845632541", "https://reviews.com.np/uploads/images/Article/Hyundai/17-9-20/Ford-festive-offer-2020-body.jpg", "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        OfferService.addOffer(new OfferModel("Rajesh Hamal", "https://thehimalayantimes.com/uploads/imported_images/wp-content/uploads/2017/05/Rajesh-Hamal.jpg", "9845632541", "https://www.crushpixel.com/big-static13/preview4/special-offer-sale-fire-burn-1250537.jpg", "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        OfferService.addOffer(new OfferModel("Rajesh Hamal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpymOtFg3-Hl7XVfqpahVQykw6dAq4VumQ-_zKbqGyDl9cYURqi4rjW05Z76OiS85ewYs&usqp=CAU", "9845632541", "https://reviews.com.np/uploads/images/Article/Hyundai/17-9-20/Ford-festive-offer-2020-body.jpg", "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
    }

    public static void populateProblem() {
        ProblemService.addProblem(new ProblemModel("Rajesh Hamal", R.drawable.brand_logo, "9845632541", R.drawable.cat, "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        ProblemService.addProblem(new ProblemModel("Rajesh Hamal", R.drawable.brand_logo, "9845632541", R.drawable.cat, "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        ProblemService.addProblem(new ProblemModel("Rajesh Hamal", R.drawable.brand_logo, "9845632541", R.drawable.cat, "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        ProblemService.addProblem(new ProblemModel("Rajesh Hamal", R.drawable.brand_logo, "9845632541", R.drawable.cat, "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        ProblemService.addProblem(new ProblemModel("Rajesh Hamal", R.drawable.brand_logo, "9845632541", R.drawable.cat, "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
        ProblemService.addProblem(new ProblemModel("Rajesh Hamal", R.drawable.brand_logo, "9845632541", R.drawable.cat, "This is description for offer", "21 Jan. 2021", "25 Jan, 2021"));
    }
}
