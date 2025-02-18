import model.*;
import service.UserProfileService;

package controll;

public class UserProfileController {
    public class UserProfileController {
        private UserProfileService userProfileService;

        public UserProfileController(client userProfileService) {
            this.userProfileService = userProfileService;
        }

        public client getUserProfile(int userId) {
            return userProfileService.getUserProfile(userId);
        }

        public void updateUserProfile(client userProfile) {
            userProfileService.updateUserProfile(userProfile);
        }

        public void deleteUserProfile(int userId) {
            userProfileService.deleteUserProfile(userId);
        }
    }
}
