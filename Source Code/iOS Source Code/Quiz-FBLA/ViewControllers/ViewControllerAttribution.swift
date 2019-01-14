//
//  ViewControllerAttribution.swift
//  Quiz-FBLA
//
//  Created by Arez Khidr on 1/14/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import UIKit

class ViewControllerAttribution: UIViewController {
//Attributions header
    @IBOutlet weak var attributionHeader: UIView!
    override func viewDidLoad() {
        super.viewDidLoad()
        hideHeaderCorners()

        // Do any additional setup after loading the view.
    }
    
    func hideHeaderCorners() {
        self.attributionHeader.layer.maskedCorners = [.layerMinXMaxYCorner, .layerMaxXMaxYCorner]
    }
    //Swipe Action to go back to home
    @IBAction func swipeToHome(_ sender: Any) {
        performSegue(withIdentifier: "attributionToHome", sender: ViewControllerHome.self)
    }
}
