//
//  ViewControllerTrivia.swift
//  Quiz-FBLA
//
//  Created by Arez Khidr on 1/8/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import UIKit


class ViewControllerTrivia: UIViewController {
//Variables that determine the selection of the categories as a Bool value
    var historySelection = Bool()
    var fblaEventsSelection = Bool()
    var businessSkillsSelection = Bool()
    var nationalSponsorsSelection = Bool()
    var nationalOfficeSelection = Bool()
    // Label that appears if no categories are selected
    @IBOutlet weak var warningLabel: UILabel!
    //Header of Trivia Page and func to mask its rounded corners
    @IBOutlet weak var triviaHeader: UIView!
    func roundTrivaHeader() {
        self.triviaHeader.layer.maskedCorners = [.layerMinXMaxYCorner, .layerMaxXMaxYCorner]
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        roundTrivaHeader()
    }
    //Start Button for game that runs an if-else to make sure a category is selected
    @IBAction func startGame(_ sender: Any) {
        if historySelection != true, businessSkillsSelection != true, fblaEventsSelection != true, nationalSponsorsSelection != true,
            nationalOfficeSelection != true {
            warningLabel.alpha = 1
        } else {
        performSegue(withIdentifier: "triviaToGame", sender: self)
        }
    }
    //Tranfers data to other view controller to select categories
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let vc = segue.destination as! ViewControllerGame
        vc.historyCategorySelection = historySelection.self
        vc.fblaEventsCategorySelection = fblaEventsSelection.self
        vc.businessSkillsCategorySelection = businessSkillsSelection.self
        vc.nationalOfficeCategorySelection = nationalOfficeSelection.self
        vc.nationalSponsorsCategorySelection = nationalSponsorsSelection.self
        
    }

    //Switches
    //Changes bool value to be sent to other view controller
   @IBAction func historySelection(_ sender: UISwitch) {
       if (sender.isOn == true) {
            historySelection = true
       } else {
        historySelection = false
    }
}
    
    @IBAction func fblaEventsSelection(_ sender: UISwitch) {
        if (sender.isOn == true) {
            fblaEventsSelection = true
        } else {
            fblaEventsSelection = false
        }
    }
    
    @IBAction func businessSkillsSelection(_ sender: UISwitch) {
        if (sender.isOn == true) {
         businessSkillsSelection = true
        } else {
            businessSkillsSelection = false
        }
    }
    
    @IBAction func nationalSponsorsSelection(_ sender: UISwitch) {
        if (sender.isOn == true){
            nationalSponsorsSelection = true
        } else {
            nationalSponsorsSelection = false
    }
    }
    
    @IBAction func nationalOfficeSelection(_ sender: UISwitch) {
        if (sender.isOn == true) {
            nationalOfficeSelection = true
        } else {
            nationalOfficeSelection = false
        }
    }
    // Swipe action to go to home 
    @IBAction func swipeToHome(_ sender: Any) {
        performSegue(withIdentifier: "triviaToHome", sender: ViewControllerHome.self)
    }
    
}
