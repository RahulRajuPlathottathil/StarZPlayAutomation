package base;

import java.util.*;
import java.util.stream.Collectors;

import DataLogics.ImageLogic;
import DataProviders.ExpectedValues;
import api.World;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import pojo.LayoutModel.Layout;
import pojo.LayoutModel.Module;
import pojo.Page;
import utility.PropertyReader;


public class ExtractDataFromResponse {
	private static Layout layouts;
	private static List<Page> pages;

	public static void apiScrambler() {
		try {
			layouts = World.getLayout();
			List<Module> layoutModules = layouts.getModules();
			List<Page> pages = World.getMovie();
			System.out.println("Page:  "+pages);
            if(pages.size()==0){
				BaseTest.test.log(Status.FAIL,"No Page");
			}
			layoutModules.forEach(layoutmodule -> {
				Map<String, Object> layoutModuleMap = new LinkedHashMap<>();
				Map<String, Object> pageModuleTitleMap = new LinkedHashMap<>();
				Map<String, Object> pageModuleImageMap = new LinkedHashMap<>();
				long layoudModuleID = layoutmodule.getId();
				String layoutModuleGUID = layoutmodule.getGuid();
				String layoutModuleCategory = layoutmodule.getCategory();
				int layoutModulesItems = layoutmodule.getItems();

				Page pageModule = findModuleFromModuleResponse(pages, layoudModuleID);

				if( PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
				  BaseTest.test.info("<div style=\"background-color: #ffcc00; width: 200px; height: 20px;\">" + layoutModuleCategory + "</tr>");
				if(layoutModuleCategory.trim().equals("ListBrandsActive")){
					Status status=(layoutModulesItems==0) ?Status.PASS:Status.FAIL;
					if(status.equals(Status.PASS) ) {
						if (PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
							BaseTest.test.log(Status.PASS, "Field :" + layoutModuleCategory + " validation Items count=" + layoutModulesItems);
					}
					else
						BaseTest.test.log(Status.FAIL, "Field :" + layoutModuleCategory + " validation Items count=" + layoutModulesItems);
				}
				long pageID = pageModule.getId();
				List<Page.Title> moduleTitles = pageModule.getTitles();
				int titleCounter = 0;
				for (Page.Title moduleTitle : moduleTitles) {
					String pageModuletitle = moduleTitle.getTitle();
					long pageModuleTitleId = moduleTitle.getId();
					if (PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
					BaseTest.test.info("Title : " + pageModuletitle + "  Module ID : " + pageModuleTitleId);
					List<String> adsCountryRight = moduleTitle.getAdsCountryRights();
					List<String> contentOwnership = moduleTitle.getContentOwnership();
					List<String> subScriptions = moduleTitle.getSubscription();
					List<Page.Title.Image> images = moduleTitle.getImages();
					int programType = moduleTitle.getProgramType();
					int ageRating = moduleTitle.getAgeRating();

					LogStatus.Verify("ID", pageID, layoudModuleID);
					if (contentOwnership!=null)
					//LogStatus.Verify("ContentOwnership", ExpectedValues.contentOwnership, contentOwnership);
						LogStatus.VerifyContentOwnership("ContentOwnership",contentOwnership);
					LogStatus.verifyProgramType(moduleTitle.getProgramType(),moduleTitle);

					LogStatus.Verify("ageRating", ExpectedValues.ageRating, ageRating);
					//LogStatus.Verify("subScription", ExpectedValues.subscription, subScriptions);
					LogStatus.VerifySubsciption("Subscription",subScriptions);
					LogStatus.Verify("ID", pageID, layoudModuleID);
					if (adsCountryRight!=null)
					LogStatus.VerifyCountryRights("adsCountryRight",adsCountryRight);

			
					int imgCounter = 0;
					List<String> imgList = new ArrayList<>();
					for (Page.Title.Image img : images) {
						String imgType = img.getType();
						String imgUrl = img.getUrl();
						imgList.add(imgType);
					}
					System.out.println("*****"+layoutModuleCategory);
					System.out.println(imgList+"-----"+imgList.size());
					// System.out.println(pageModuleImageMap);
					Hashtable<String, String> table = ImageLogic.getImageCount(layoutModuleCategory,
							ImageLogic.getPlatform(), ImageLogic.getVersion(), ImageLogic.getOrigin());
					System.out.println(layoutModuleCategory);
					String expected = table.get(layoutModuleCategory);
					int expectedCount = Integer.parseInt(expected);
					int actual = images.size();

					LogStatus.VerifyActalGreaterThanOrEqualsExpected("Carosel_Image_count", expectedCount, actual);

					List<String> imgTypesList = Arrays
							.asList(table.get(layoutModuleCategory + "_imageType").split(","));

					LogStatus.Verify("Image Type", imgTypesList, imgList);
					titleCounter++;

				}

			});
			BaseTest.extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail(e.getMessage());
		}

	}

	public static Page findModuleFromModuleResponse(List<Page> pages, long layoutModuleID) {

		try {
			List<Page> pageModules = pages.stream().filter(moduleID -> (moduleID.getId() == layoutModuleID))
					.collect(Collectors.toList());
			return pageModules.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return null;

	}

}
