# DeFaust
Taking the devil out of the deal.

DeFaust is a peer-to-peer network that stores and maintains data about entities, specifically people, in a secure way. It makes this data accessible to authorized users while preventing access to the unencrypted data by unauthorized users. It provides a distributed, fault tolerant storage infrastructure while guaranteeing control of the data to the owner of the data. It is intended to form the backbone of any number of applications that want to generate and use profile data while simultaneously guaranteeing that that data remains completely under the control of the person the data pertains to.

DeFaust is intended to allow users to realize the power of big data and data science without fear of what another entity might be doing with that data, in other words, taking the devil out of the deal.

Each identity in the DeFaust network is a combination of
* a public and private key
* an archive containing a blockchain and files representing non-textual data referenced within the blockchain.
* an executable (of some sort) that provides encryption and decryption of the data stored in the archive

Access to identity's data is controlled by a client providing decrypted data on request leveraging a service registry mechanism. Each authorized client is "registered" to provide data for an ID or IDs.

Each block in the blockchain represents a delta between the current state of the identity and the previous state of the identity. Each block also has the added requirements of being encrypted using the public key and requiring authorization of any changes to the identity.

The executable implements access controls by mapping symetric encryption keys to data within the entity. This allows multiple other entities to have various permissions reading and writing data, while providing for access to that data even when a given client is not available (connected to the network). It also facilitates transaction verification when the originating client is not available. Transaction verification should be done using [zero-knowledge proof](https://en.wikipedia.org/wiki/Zero-knowledge_proof), and preferrably [witness indestinguishable proof](https://en.wikipedia.org/wiki/Witness-indistinguishable_proof).

Identities are stored in / on a [Kademlia](https://en.wikipedia.org/wiki/Kademlia) based DHT or some other form of DFS. This is necessary for resiliency / fault tolerance so that if the originating client is lost the identity can be rebuilt if the keys have been retained. Data could be moved around based on a number of factors, one of the easiest being frequency of interaction of two identities. Geographic redundancy and other factors could be taken into consideration as well. Kademlia is also used for routing messages within the network.

Clients could, and would probably eventually need to, archive, deep archive, and possibly even purge data. The difficulty here is in maintaining records of transactions in case validation of a transaction in which the identity was participant is ever requested (ie, did you X?).

The client could have limits on storage used. Further limits could restrict bandwidth used, processing power, etc. By monitoring these things storage could be allowed to expand until one of the thresholds is exceeded.

## Important Considerations
All connections would need to be secure.

## Important Questions to Answer
* How do we guarantee that somebody requesting to read data does not keep that data?.
* What if a key is generated based on a seed time and once the seed time has gone beyond a certain point the key is no longer valid? This provides a data aging mechanism, but it does not guarantee the destruction of the data once it has exceeded it's time to live.
* How would network segmentation be handled? What if the network were segmented (sharded) by design? What if every instance / identity had it's own network?

## Feats / Achievements / Accomplishments
Requires sign offs by multiple witnesses or a "credible authority". For example, completing a training course might result in an achievement from a "credible authority" and completing a more informal achievement and getting signatures from witnesses might also yield an achievement.

## Challenge Mechanism
For achievements gained through witnesses, and maybe all achievements, other users / players could challenge. If the person challenged can perform the feat then that person wins the challenge. If they cannot then the challenger wins. This could be gamified by then allowing the person successfully completing the challenge to in turn challenge their challenger.

## Duels
Like challenge mechanism, but not based on an achievement / accomplishment.

## Etc
Allow users to associate media to events, ie, movies and pictures.

The theme of peer review and approval would be repeated throughout the system. Part of the idea is that if "witnesses" witnessing a feat are reviewed and found to be false or inaccurate they would be flagged as untrusworthy (dishonorable) and not permitted to witness / judge / score for others. The "challenge" mechanic could possibly contribute to this as well (though I think it may be more effective merely as a threat).

There would also be "trusted" or pre-approved witnesses. For example, a personal trainers should be able to sign off for their clients without additional witnesses.
