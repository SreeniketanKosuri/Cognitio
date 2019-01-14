//
//  ViewControllerEndScreen.swift
//  Quiz-FBLA
//
//  Created by Arez Khidr on 1/10/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import UIKit
import Lottie


class ViewControllerEndScreen:
UIViewController {
    var displayScore = Int()
    @IBOutlet weak var smileyFaceAnimation: LOTAnimationView!
    override func viewDidLoad() {
        super.viewDidLoad()
        animateSmileyFace()
        displayRandomMessage()
        

        // Do any additional setup after loading the view.
    }
    //Animation
    func animateSmileyFace() {
        smileyFaceAnimation.setAnimation(named: "smile")
        smileyFaceAnimation.play()
    }
    
   
    @IBAction func restartQuizPress(_ sender: Any) {
        performSegue(withIdentifier: "endScreenToTrivia", sender: ViewControllerTrivia.self)
    }
   
    //Positive message displayed at random
    @IBOutlet weak var positiveMessage: UILabel!
    let positiveMessageArray = ["Great job!", "Awesome Effort!", "Amazing!" ]
    func displayRandomMessage() {
        positiveMessage.text = (positiveMessageArray.randomElement())
}
}
