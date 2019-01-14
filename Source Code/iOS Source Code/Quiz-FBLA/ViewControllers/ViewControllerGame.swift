//
//  ViewControllerGame.swift
//  FBLA Quiz 4
//
//  Created by Arez Khidr on 1/8/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import UIKit



class ViewControllerGame: UIViewController {
//Var of selected categories sent from previous view controller
var historyCategorySelection = Bool()
var fblaEventsCategorySelection = Bool()
var businessSkillsCategorySelection = Bool()
var nationalSponsorsCategorySelection = Bool()
var nationalOfficeCategorySelection = Bool()
    // Outlets for aspects of the game UI
    @IBOutlet weak var questionCounter: UILabel!
    @IBOutlet weak var scoreLabel: UILabel!
    @IBOutlet weak var progressView: UIView!
    @IBOutlet weak var questionLabel: UILabel!
    
    //Outlet for Buttons
    @IBOutlet weak var optionA: UIButton!
    @IBOutlet weak var optionB: UIButton!
    @IBOutlet weak var optionC: UIButton!
    //selectedQuestionBank
    var allQuestions = [Question]()
    //Array of all the questions created using custom Question Class
    var historyQuestions = [(Question(questionText: "History: Who was the founder of the FBLA program?", choiceA: "A. Edward D. Miller", choiceB: "B. Conrad N. Hilton", choiceC: "C. Hamden L. Forkner", answer: 3)), (Question(questionText: "What is appropriate FBLA business attire?", choiceA: "Business Formal", choiceB: "B. Conrad N. Hilton", choiceC: "C. Hamden L. Forkner", answer: 3)), (Question(questionText: "History: What does FBLA stand for?", choiceA: "A. Formidable Business Learners of America", choiceB: "B. Future Business Learners of America", choiceC: "C.Future Business Leaders of America", answer: 3)),(Question(questionText: "What does FBLA’s college division (PBL) stand for?", choiceA: "Professional Business Leaders", choiceB: "Phi Beta Lambda", choiceC: "Profound Brilliant Learners", answer: 2)), (Question(questionText: "Where was the first FBLA high school chapter chartered?", choiceA: "Colorado", choiceB: "Tennessee", choiceC: "Iowa", answer: 2)), (Question(questionText: "Who was the first full-time executive director of FBLA?", choiceA: "Edward D. Miller", choiceB: "Jean J. Buckley", choiceC: "Elena M. Daly", answer: 1)), (Question(questionText: "In what year was the grand opening of the FBLA-PBL National Center?", choiceA: "1987", choiceB: "1992", choiceC: "1991", answer: 3)), ]
    
    var fblaEventsQuestions = [(Question(questionText: "What type of event is “Introduction to Financial Math?", choiceA: "Objective Test", choiceB: "Prejudged Project & Presentation", choiceC: "Prejudged Report", answer: 1)), (Question(questionText: "Which of the following is NOT a Prejudged Project & Presentation event?", choiceA: "Computer Game & Simulation Programming", choiceB: "Database Design & Applications", choiceC: "E-business", answer: 2)), (Question(questionText: "What are events specifically for grades 9 — 10 called?", choiceA: "Introduction Events", choiceB: "Preliminary Events", choiceC: "Fundamental Events", answer: 1)), (Question(questionText: "Fill in the blank: Competitors can choose to compete ____", choiceA: "Individually or with a team", choiceB: "With a team or chapter team", choiceC: "Individually, with a team, or with a chapter team", answer: 3)), (Question(questionText: "Which of the following is an FBLA Chapter event?", choiceA: "Community Service Project", choiceB: "Business Financial Plan", choiceC: "Client Service", answer: 1)), (Question(questionText: "How many “Speech” events are available in FBLA?", choiceA: "1", choiceB: "5", choiceC: "3", answer: 3)), (Question(questionText: "Which of the following is the ONLY Prejudged Report event?", choiceA: "Business Plan", choiceB: "Local Chapter Annual Business Report", choiceC: "American Enterprise Project", answer: 2)) ]
    
    var businessSkillsQuestions = [(Question(questionText: "What is appropriate FBLA business attire?", choiceA: "Business Formal", choiceB: "Business Casual", choiceC: "Formal", answer: 1)), (Question(questionText: "Which of these shoes are appropriate for an FBLA Event?", choiceA: "Canvas and fabric shoes", choiceB: "Dress shoes/boots", choiceC: "Hiking Boots", answer: 2)), (Question(questionText: "Which of the following items are unacceptable at an FBLA event?", choiceA: "Business Dress", choiceB: "Collared Dress Shirt and a Tie", choiceC: "Shorts", answer: 3)), (Question(questionText: "What must be worn at all conference functions?", choiceA: "Flip Flops", choiceB: "Name Badges", choiceC: "Hats", answer: 2)), (Question(questionText: "As written in the FBLA Code of Ethics, an FBLA member shall dress and act in a manner that will bring respect to me and to my ____", choiceA: "School", choiceB: "Chapter", choiceC: "Classmates", answer: 1)), (Question(questionText: "What is the first line in the FBLA Code of Ethics?", choiceA: "Willingly accept responsibilities and duties", choiceB: "Be honest and sincere", choiceC: "Always be punctual ", answer: 2)), (Question(questionText: "What should all FBLA members observe in the conference program?", choiceA: "Breakfast Options", choiceB: "Meal Times", choiceC: "Curfew", answer: 3)),]
    
    var nationalSponsorsQuestions = [ (Question(questionText: "Which of the following technology companies offers member discounts for FBLA?", choiceA: "AT&T", choiceB: "HP", choiceC: "Google", answer: 2)), (Question(questionText: "Which major insurance company sponsors FBLA?", choiceA: "Progressive", choiceB: "Liberty Mutual", choiceC: "Geico", answer: 3)), (Question(questionText: "Which major educational company that produces many textbooks sponsors FBLA?", choiceA: "Cengage", choiceB: "Schoology", choiceC: "Pearson", answer: 1)),  (Question(questionText: "Which of these online shopping websites sponsor FBLA?", choiceA: "Etsy", choiceB: "Amazon", choiceC: "Ebay", answer: 2)), (Question(questionText: "Which of these sponsors provides fundraising for FBLA?", choiceA: "Country Meats", choiceB: "Alamo Rent A Car", choiceC: "Amazon", answer: 1)), (Question(questionText: "Which website creating company sponsors FBLA?", choiceA: "Wix", choiceB: "Weebly", choiceC: "SquareSpace", answer: 3)), (Question(questionText: "Which of the following organizations provide sponsorships for FBLA?", choiceA: "Berkeley College, Champlain College, and Cumberland University", choiceB: "Berkeley College, Yale University, and Champlain College", choiceC: "Harvard University, Arizona State University, and Colorado State University", answer: 1)), ]
    
    var nationalOfficeQuestions = [(Question(questionText: "Who is the current FBLA CEO?", choiceA: "Jean M. Buckley", choiceB: "Jacob D. Berkeley", choiceC: "Marissa H. Hoffmann", answer: 1)), (Question(questionText: "Who is the National President of FBLA?", choiceA: "Michael Shang", choiceB: "Eu Ro Wang", choiceC: "Roberto Diaz-Gutierrez", answer: 2)), (Question(questionText: "How many total FBLA National Officers are there?", choiceA: "6", choiceB: "13", choiceC: "9", answer: 3)), (Question(questionText: "How is the FBLA National Parliamentarian appointed?", choiceA: "Election", choiceB: "Exam Score", choiceC: "Selection by CEO", answer: 2)), (Question(questionText: "Which of the following positions serves on the Board of Directors?", choiceA: "National Treasury", choiceB: "National Parliamentarian", choiceC: "National President", answer: 3)), (Question(questionText: "How many FBLA Regional Vice Presidents are there for each region?", choiceA: "2", choiceB: "4", choiceC: "1", answer: 3)), (Question(questionText: "Where and by who are National Officers elected every year?", choiceA: "FBLA Headquarters / Board of Directors", choiceB: "National Leadership Conference (NLC) / Board of Directors", choiceC: "National Leadership Conference (NLC) / Peer", answer: 3)), ]
   
    var questionNumber: Int = 0
    var score: Int = 0
    var selectedAnswer: Int = 0
    
    
    //Making only the top corners of the progress view visible
    func roundProgressCorners() {
    self.progressView.layer.maskedCorners = [.layerMinXMinYCorner, .layerMaxXMinYCorner]
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        questionSelectionHistory()
        questionSelectionFBLAEvents()
        questionSelectionBusinessSkills()
        questionSelectionNationalOffice()
        questionSelectionNationalSponsors()
        roundProgressCorners()
        updateQuestion()
        updateUI()
        
        
        // Do any additional setup after loading the view.
    }
    
    @IBAction func answerPressed(_ sender: UIButton) {
        if sender.tag == selectedAnswer{
            print("correct")
            score += 1
        }else {
            print("wrong")
        }
        questionNumber += 1
        updateQuestion()
        
    }
    func updateQuestion(){
        
        if questionNumber <= allQuestions.count - 1{
            questionLabel.text = allQuestions[questionNumber].question
            optionA.setTitle(allQuestions[questionNumber].optionA, for: UIControl.State.normal)
            optionB.setTitle(allQuestions[questionNumber].optionB, for: UIControl.State.normal)
            optionC.setTitle(allQuestions[questionNumber].optionC, for: UIControl.State.normal)
            selectedAnswer = allQuestions[questionNumber].correctAnswer
            updateUI()
            
        }else {
            restartQuiz()
            performSegue(withIdentifier: "gameToEndScreen", sender: ViewControllerEndScreen.self)
        }
        
        
    }
    func updateUI(){
        scoreLabel.text = "Score: \(score)"
        questionCounter.text = "\(questionNumber + 1)/\(allQuestions.count)"
        progressView.frame.size.width = (view.frame.size.width / CGFloat(allQuestions.count)) * CGFloat(questionNumber + 1)
        
    }
    func restartQuiz(){
        score = 0
        questionNumber = 0
        updateQuestion()
        
    }
    //Adds Categories if selected in previous view controller
    
    func questionSelectionHistory() {
        if historyCategorySelection == true {
            allQuestions.append(contentsOf: historyQuestions)
        }
    }
    func questionSelectionFBLAEvents() {
        if fblaEventsCategorySelection == true {
            allQuestions += fblaEventsQuestions
        }
    }
    func questionSelectionBusinessSkills() {
        if businessSkillsCategorySelection == true {
            allQuestions += businessSkillsQuestions
        }
    }
    func questionSelectionNationalSponsors() {
        if nationalSponsorsCategorySelection == true {
            allQuestions += nationalSponsorsQuestions
        }
    }
    func questionSelectionNationalOffice() {
        if nationalSponsorsCategorySelection == true {
            allQuestions += nationalOfficeQuestions
        }
}

}
